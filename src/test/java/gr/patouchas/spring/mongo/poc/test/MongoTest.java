package gr.patouchas.spring.mongo.poc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import gr.patouchas.spring.mongo.poc.SpringMongoConfig;
import gr.patouchas.spring.mongo.poc.User;
import gr.patouchas.spring.mongo.poc.UserGroup;
import gr.patouchas.spring.mongo.poc.repositories.UserGroupRepository;
import gr.patouchas.spring.mongo.poc.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMongoConfig.class})
public class MongoTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserGroupRepository userGroupRepository;

	private static final String USER_GROUP_NAME = "AdminGroup1";
	private static final String USER_NAME = "Jack1";

	@Test
	public void test() throws Exception{

		final UserGroup ug = new UserGroup();
		ug.setName(USER_GROUP_NAME);
		this.userGroupRepository.insert(ug);

		final UserGroup ug2= this.userGroupRepository.findOne(ug.getId());
		Assert.notNull(ug2);

		final User u = new User();
		u.setName(USER_NAME);
		final List<UserGroup> usergroups = new ArrayList<>();
		usergroups.add(ug2);
		u.setUsergroups(usergroups);
		this.userRepository.insert(u);

		final User u2 = new User();
		u2.setName("testname");
		final List<UserGroup> usergroups2 = new ArrayList<>();
		usergroups2.add(ug2);
		u.setUsergroups(usergroups2);
		this.userRepository.insert(u2);

		Assert.notNull(this.userRepository.findByNameIgnoreCase(USER_NAME));
		Assert.notNull(this.userRepository.findByUsergroupsId(ug.getId()));
		Assert.notNull(this.userGroupRepository.findOne(ug.getId()));

	}
}
