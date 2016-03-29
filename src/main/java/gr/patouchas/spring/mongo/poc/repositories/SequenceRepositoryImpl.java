package gr.patouchas.spring.mongo.poc.repositories;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.util.Assert;

import gr.patouchas.spring.mongo.poc.AbstractEntity;
import gr.patouchas.spring.mongo.poc.Sequence;
import gr.patouchas.spring.mongo.poc.enumeration.SequenceEnum;

/**
 * This class should be extended by every repository implementation that supports an AbstractEntity that needs auto generated id.
 *
 * @param <T> the generic type
 */
public abstract class SequenceRepositoryImpl<T extends AbstractEntity<Long>> extends SimpleMongoRepository<T, Long> {

	@SuppressWarnings("unchecked")
	public SequenceRepositoryImpl(final MongoTemplate mongoTemplate, final Class domainClass) {
		super(new MongoRepositoryFactory(mongoTemplate).<T, Long>getEntityInformation(domainClass), mongoTemplate);
		this.mongoTemplate = mongoTemplate;
	}

	private static String ID = "id";

	private static String SEQ = "seq";

	public final MongoTemplate mongoTemplate;

	@Override
	public <S extends T> S insert(final S abstractEntity) {
		Assert.notNull(abstractEntity, "Entity must not be null!");
		try {
			if (abstractEntity.getId() != null){
				return super.save(abstractEntity);
			} else {
				return super.insert(this.setNextId(abstractEntity));
			}
		} catch (final Exception e){
			throw new RuntimeException(String.format("Error during save or insert of entity: %s.", abstractEntity), e);
		}
	}

	private <S extends T> S  setNextId(final S abstractEntity) throws Exception {
		final String sequenceName = SequenceEnum.byClass(abstractEntity.getClass()).getSeqName();
		try {
			final Sequence sequence = this.mongoTemplate.findAndModify(query(where(ID).is(sequenceName)), new Update().inc(SEQ, 1),
					options().returnNew(true).upsert(true), Sequence.class);
			abstractEntity.setId(sequence.getSeq());
			return abstractEntity;

		} catch (final DataAccessResourceFailureException e) {
			throw new Exception(String.format("[sequence:%s] number could not be retrieved due to DB connection failure.",
					sequenceName), e);
		} catch (final DataAccessException e) {
			throw new Exception(String.format("[sequence:%s] number could not be retrieved due to DB related issue.", sequenceName), e);
		}
	}
}
