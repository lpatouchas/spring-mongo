package gr.patouchas.spring.mongo.poc.service;

import java.io.Serializable;
import java.util.List;

import gr.patouchas.spring.mongo.poc.AbstractEntity;


/**
 * The interface Abstract service contains the common CRUD methods used for entity T. In case of custom implementations, these should be overriden
 * from the extended services.
 *
 * @param <T> the type to execute operations
 * @param <ID>
 */
public interface AbstractService<T extends AbstractEntity<ID>, ID extends Serializable> {

	/**
	 * Save new entity.
	 *
	 * @param entity the entity to save
	 * @return the updated entity
	 * @throws IriDataException
	 */
	T insert(T entity);

	/**
	 * Save list of new entities.
	 *
	 * @param entities to save
	 * @return the updated entities
	 */
	List<T> insert(List<T> entities);

	/**
	 * Save or update entity. If an Id has not been set it will throw an assert error
	 *
	 * @param entity the entity to save
	 * @return the updated entity
	 * @throws IriDataException
	 */
	T save(T entity);

	/**
	 * Save or update list of entities.
	 *
	 * @param entities to save
	 * @return the updated entities
	 */
	List<T> save(List<T> entities);

	/**
	 * Find an entity of type <T> by it's id.
	 *
	 * @param id the id
	 * @return the entity
	 * @throws IriDataException
	 */
	T findOne(ID id);

	/**
	 * Delete the entity of type <T> having the given id.
	 *
	 * @param id the entity id
	 */
	void delete(ID id);

	/**
	 * Delete all entities.
	 *
	 * @param entities the entities to delete
	 */
	void delete(final List<T> entities);

	/**
	 * Find all entities of type <T>.
	 *
	 * @return the entity
	 */
	List<T> findAll();
}
