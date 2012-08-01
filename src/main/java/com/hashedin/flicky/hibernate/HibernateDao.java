package com.hashedin.flicky.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


/**
 * Used for accessing DB through Hibernate.
 */
@SuppressWarnings("unchecked")
public class HibernateDao extends HibernateDaoSupport implements IDataAccessObject
{

    /**
     * Bulk update.
     * 
     * @param query String query to run
     * @param values Parameters provided to the queries
     * 
     * @return Number of rows updated
     * 
     * java.lang.Object[])
     */
    @Transactional
    public int bulkUpdate(final String query, final Object... values)
    {
        return getHibernateTemplate().bulkUpdate(query, values);
    }

    /**
     * Clear.
     * 
     */
    public void clear()
    {
        getHibernateTemplate().clear();
    }

    /**
     * Deletes the object entity.
     * 
     * @param entity Object to delete
     * 
     */
    @Transactional
    public void delete(final Object entity)
    {
        getHibernateTemplate().delete(entity);
    }

    /**
     * Deletes all entities.
     * 
     * @param entities Entities to Delete
     */
	@Transactional
    public void deleteAll(final Collection entities)
    {
        getHibernateTemplate().deleteAll(entities);
    }

    /**
     * Queries the database using the provided query and argument value.
     * 
     * @param query Query String
     * @param values Values provided to the Query
     * 
     * @return List of all objects satisfying the query
     */
	public List find(final String query, final Object... values)
    {
        return getHibernateTemplate().find(query, values);
    }

    /**
     * Uses a hibernate criteria query to find a list of objects.
     * 
     * @param detachedCriteria Hibernate criteria to search by
     * 
     * @return List of Objects satisfying the query
     */
	public List findByCriteria(final DetachedCriteria detachedCriteria)
    {
        return getHibernateTemplate().findByCriteria(detachedCriteria);
    }

    /**
     * Uses an example object to find similar objects.
     * 
     * @param example Example object to find objects like it
     * 
     * @return List of Objects satisfying the query
     */
	public List findByExample(final Object example)
    {
        return getHibernateTemplate().findByExample(example);
    }

    /**
     * Flush.
     */
    public void flush()
    {
        getHibernateTemplate().flush();
    }

    /**
     * Loads an object using the provided id. This doesn't actually load the object but just returns
     * a proxy to it.
     * 
     * @param type Type of object to load
     * @param id Id of the object
     * 
     * @return Object with specified type and id
     */
	public Object load(final Class type, final Serializable id)
    {
        return getHibernateTemplate().load(type, id);
    }

    /**
     * Loads all the objects with the specified type.
     * 
     * @param type Type of the object
     * 
     * @return List of all objects of the specified type
     */
	public List loadAll(final Class type)
    {
        return getHibernateTemplate().loadAll(type);
    }

    /**
     * Merge.
     * 
     * @param object Object to merge
     */
    @Transactional
    public Object merge(final Object object)
    {
        return getHibernateTemplate().merge(object);
    }

    /**
     * (non-Javadoc).
     * 
     * @param object Object to refresh
     */
    public void refresh(final Object object)
    {
        getHibernateTemplate().refresh(object);
    }

    /**
     * Save or update.
     * 
     * @param entity Entity to save
     */
    @Transactional
    public void saveOrUpdate(final Object entity)
    {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    /**
     * Save or update all.
     * 
     * @param entities Entities to save
     */
	@Transactional
    public void saveOrUpdateAll(final Collection entities)
    {
        getHibernateTemplate().saveOrUpdateAll(entities);
    }
	
	
	@Transactional
    public void limitSize(final int maxResults)
    {
        getHibernateTemplate();
    }
}
