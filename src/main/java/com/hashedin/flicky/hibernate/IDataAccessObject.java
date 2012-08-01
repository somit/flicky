package com.hashedin.flicky.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


/**
 * Forms a layer of abstraction for accessing the Database.
 */

@SuppressWarnings("unchecked")
public interface IDataAccessObject
{

    /**
     * Used to run a bulk-update on the database.
     * 
     * @param query String query to run
     * @param values Parameters to set the the query
     * 
     * @return Number of records modified by this
     */
    int bulkUpdate(String query, Object... values);

    /**
     * Clears the session, canceling all pending saves, updates, deletions.
     */
    void clear();

    /**
     * Deletes the object entity.
     * 
     * @param entity Object to delete
     */
    void delete(Object entity);

    /**
     * Deletes all entities.
     * 
     * @param entities Entities to Delete
     */
	void deleteAll(Collection entities);

    /**
     * Queries the database using the provided query and argument value.
     * 
     * @param query Query String
     * @param values Values provided to the Query
     * 
     * @return List of Objects satisfying the query
     */
	List find(String query, Object... values);

    /**
     * Uses a hibernate criteria query to find a list of objects.
     * 
     * @param detachedCriteria Hibernate criteria to search by
     * 
     * @return List of Objects satisfying the query
     */
	List findByCriteria(DetachedCriteria detachedCriteria);

    /**
     * Uses an example object to find similar objects.
     * 
     * @param example Example object to find objects like it
     * 
     * @return List of Objects satisfying the query
     */
	List findByExample(Object example);

    /**
     * Flushes all changes into the database.
     */
    void flush();

    /**
     * Loads an object using the provided id. This doesn't actually load the object but just returns
     * a proxy to it.
     * 
     * @param type Type of object to load
     * @param id Id of the object
     * 
     * @return Object with the specified type and id
     */
	Object load(Class type, Serializable id);

    /**
     * Loads all the objects with the specified type.
     * 
     * @param type Type of the object
     * 
     * @return List of all objects with the specified type
     */
	<X> List<X> loadAll(Class<X> type);

    /**
     * Merges the object into a persistence object from the session. If the object does not exist in
     * the session, it is loaded from the database.
     * 
     * @param entity Object to merge
     */
    Object merge(Object entity);

    /**
     * Refreshes the entity, reading its state from the Database.
     * 
     * @param entity Entity to refresh
     */
    void refresh(Object entity);

    /**
     * Saves the object if it is a new object. Updates the object if it is already exists in the
     * Database.
     * 
     * @param entity Object to save or update
     */
    void saveOrUpdate(Object entity);

    /**
     * Save/Updates all the objects in the collection.
     * 
     * @param entities Objects to save or update
     */
	void saveOrUpdateAll(Collection entities);
	
    void limitSize(int maxResults);

}
