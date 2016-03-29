package gr.patouchas.spring.mongo.poc.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import gr.patouchas.spring.mongo.poc.UserGroup;

/**
 * The Class UserGroupRepositoryImpl.  This class is needed for the sequence purposes.
 */
@Repository
public class UserGroupRepositoryImpl extends SequenceRepositoryImpl<UserGroup> implements UserGroupRepositoryCustom {

	@Autowired
	public UserGroupRepositoryImpl(final MongoTemplate mongoTemplate) {
		super(mongoTemplate, UserGroup.class);
	}

	@Override
	public List<UserGroup> someCustomMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
