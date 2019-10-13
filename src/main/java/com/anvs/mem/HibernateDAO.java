package com.anvs.mem;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Criterion;

import com.anvs.mem.dao.DAO;
import com.anvs.mem.service.SessionHandler;

public abstract class HibernateDAO<T, I extends Serializable> implements DAO<T, I> {

	private SessionHandler sessionManager;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public HibernateDAO() {  
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = 
        		(Class<T>) type.getActualTypeArguments()[0];  
     }  
	
	public void setSessionManager(SessionHandler sManager) {
		this.sessionManager = sManager;
	}
	
	public List<T> findAll() {
		
		//sessionManager.beginTransaction();
		findByCriteria();
		//sessionManager.closeWithCommit();
		return null;		
	}
	
    public Class<T> getEntityClass() {  
        return entityClass;  
    } 
	
	protected List<T> findByCriteria(Expression<Boolean>... conditions) {

		// Create CriteriaBuilder
		CriteriaBuilder builder = sessionManager.getEstablishedSession().getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<T> query = builder.createQuery(getEntityClass());
		//Criteria crit = sessionManager.getEstablishedSession().createCriteria(getEntityClass());  
        for (Expression<Boolean> c : conditions) {  
            query.where(c);  
        }  
        //return query.;  
	}

	public T findById(I id) {
		T result;                                                                                        
		sessionManager.beginTransaction();
		result = (T) sessionManager.getEstablishedSession().load(entityClass, id, LockMode.READ);
		sessionManager.closeWithCommit();
		return result;
	}

	public List<T> findWithFilter(T exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(T entityToDelete) {
		sessionManager.beginTransaction();
		sessionManager.getEstablishedSession().delete(entityToDelete);
		sessionManager.closeWithCommit();
	}

	@SuppressWarnings("unchecked")
	public Serializable insert(T newEntity) {
		/*		
		 * Connect to DB
		 * Prepare insert statement
		 * Check operation status
		 * disconnect from DB
		 * 
		 * Handle errors
		 * */
		I returnedId = null;
		sessionManager.beginTransaction();
		returnedId = (I) sessionManager.getEstablishedSession().save(newEntity);
		sessionManager.closeWithCommit();
		return returnedId;
	}

	public T update(T newStateItem) {
		sessionManager.beginTransaction();
		sessionManager.getEstablishedSession().save(newStateItem);
		sessionManager.closeWithCommit();
		return newStateItem;
	}

	
}
