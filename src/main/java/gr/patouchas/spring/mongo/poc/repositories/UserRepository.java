package gr.patouchas.spring.mongo.poc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import gr.patouchas.spring.mongo.poc.User;

/**
 * The Interface UserRepository. It has some query methods that do not need implementation
 */
public interface UserRepository extends MongoRepository<User, Long>, UserRepositoryCustom {

	/**
	 * Find by name ignore case.
	 *
	 * @param name the name
	 * @return the user
	 */
	User findByNameIgnoreCase(String name);

	/**
	 * Find by usergroups id.
	 *
	 * @param id the id
	 * @return the user
	 */
	User findByUsergroupsId(Long id);
}
