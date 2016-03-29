package gr.patouchas.spring.mongo.poc.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import gr.patouchas.spring.mongo.poc.User;

/**
 * The Class UserRepositoryImpl. This class is needed for the sequence purposes.
 */
@Repository
public class UserRepositoryImpl extends SequenceRepositoryImpl<User> implements UserRepositoryCustom  {

	@Autowired
	public UserRepositoryImpl(final MongoTemplate mongoTemplate) {
		super(mongoTemplate, User.class);
	}

	@Override
	public List<User> someCustomMethod() {
		return Arrays.asList(super.findOne(1L));
	}
}
