package gr.patouchas.spring.mongo.poc.service;

import java.util.List;

import gr.patouchas.spring.mongo.poc.User;
import gr.patouchas.spring.mongo.poc.UserGroup;
import gr.patouchas.spring.mongo.poc.repositories.UserRepository;

public class UserServiceImpl extends AbstractServiceImpl<User, UserRepository, Long> implements UserService {

	@Override
	public User create(String name, List<UserGroup> usergroups) {
		User user = new User();
		user.setName(name);
		user.setUsergroups(usergroups);
		return super.mongoRepository.save(user);
	}

}
