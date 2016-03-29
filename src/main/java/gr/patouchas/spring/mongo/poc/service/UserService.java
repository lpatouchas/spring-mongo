package gr.patouchas.spring.mongo.poc.service;

import java.util.List;

import gr.patouchas.spring.mongo.poc.User;
import gr.patouchas.spring.mongo.poc.UserGroup;

public interface UserService extends AbstractService<User, Long> {

	public User create(String name, List<UserGroup> userGroups);
}
