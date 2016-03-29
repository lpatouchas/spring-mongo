package gr.patouchas.spring.mongo.poc.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import gr.patouchas.spring.mongo.poc.AbstractEntity;


/**
 * The type Abstract service impl contains the common CRUD methods used for entity T. In case of custom implementations, these should be overridden
 * from the extended services.
 *
 * @param <T> the generic type of the Entity that extends the AbstractEntity
 * @param <R> the generic type of the Repository that extends the MongoRepository
 * @param <ID> the generic type of the AbstractEntity Id
 */
public abstract class AbstractServiceImpl<T extends AbstractEntity<ID>, R extends MongoRepository<T, ID>, ID extends Serializable> implements AbstractService<T,ID> {

	/** The Repository to use for executing database operation on type <T>. */
	@Autowired
	protected R mongoRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T insert(final T entity) {
		return this.mongoRepository.insert(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> insert(final List<T> entities) {
		return this.mongoRepository.insert(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T save(final T entity) {
		return this.mongoRepository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> save(final List<T> entities) {
		return this.mongoRepository.save(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findOne(final ID id) {
		return this.mongoRepository.findOne(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final ID id) {
		this.mongoRepository.delete(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final List<T> entities) {
		this.mongoRepository.delete(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		return this.mongoRepository.findAll();
	}
}
