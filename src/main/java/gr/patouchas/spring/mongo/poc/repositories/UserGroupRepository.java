package gr.patouchas.spring.mongo.poc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import gr.patouchas.spring.mongo.poc.UserGroup;

/**
 * The Interface UserGroupRepository.
 */
public interface UserGroupRepository extends MongoRepository<UserGroup, Long>, UserGroupRepositoryCustom {

}
