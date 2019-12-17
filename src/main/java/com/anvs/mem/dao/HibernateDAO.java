package com.anvs.mem.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.SQLQuery;
import com.anvs.mem.service.SessionHandler;

public abstract class HibernateDAO<T, I extends Serializable> implements DAO<T, I> {
	
	private SessionHandler sessionManager;
	private Class<T> entityClass;
	
	public HibernateDAO(Class<T> entityClass) {  
		this.entityClass = entityClass;
//		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
//        this.entityClass = 
//        		(Class<T>) type.getActualTypeArguments()[0];  
		
     }  
	
	protected CriteriaBuilder withCriteriaBuilder() {
		CriteriaBuilder cb = getSessionManager()
				.getSession()
				.getCriteriaBuilder();
		return cb;
	}
	
	public void setSessionManager(SessionHandler sManager) {
		this.sessionManager = sManager;
	}
	
	public SessionHandler getSessionManager() {
		return sessionManager;
	}
	
    protected Class<T> getEntityClass() {  
        return entityClass;  
    } 
    
    @Override
	public List<T> findAll() {
		return findWithCriteria(null);	
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findWithCriteria(CriteriaQuery<T> criteria) {
		if (criteria == null) {
			// CriteriaQuery содержит тип возвращаемого значения и условия
			// типа SELECT f1 или * ..... where )
			criteria = withCriteriaBuilder().createQuery(getEntityClass());
			// аналог FROM <TABLE> в SQL 
			Root<T> from = criteria.from(getEntityClass());
			criteria.select(from);
		}
		
        List<T> resultList = null;
        try {
	        sessionManager.beginTransaction();
			Query q = getSessionManager().getSession().createQuery(criteria);
			// TODO ПРи неудачном поиске возвращает не null
			resultList = q.getResultList();
	        sessionManager.closeWithCommit();
        } catch (Exception he) {
        	sessionManager.closeWithRollback();
        	System.out.println("ERROR in findWithCriteria() " + he.getMessage());
        }
		return resultList;
	}
	
	public CriteriaQuery<T> likeClause(String fieldName, String mask/*, Boolean inverseClause*/) {
		CriteriaQuery<T> cq = withCriteriaBuilder().createQuery(getEntityClass());  
		Root<T> root = cq.from(getEntityClass());
		cq.select(root);
		//if (inverseClause == null || inverseClause == true) {
			cq.where(withCriteriaBuilder().like(root.get(fieldName).as(String.class), mask)); 
//		} else {
//			cq.where(cb.notLike(root.get(fieldName).as(String.class), mask)); 
//		}
		return cq;
	}
	
	public CriteriaQuery<T> equalClause(String fieldName, Object value/*, Boolean inverseClause*/) {
		CriteriaQuery<T> cq = withCriteriaBuilder().createQuery(getEntityClass());  
		Root<T> root = cq.from(getEntityClass());
		cq.select(root);
		//if (inverseClause == null || inverseClause == true) {
			cq.where(withCriteriaBuilder().equal(root.get(fieldName)/*.as(String.class)*/, value)); 
//		} else {
//			cq.where(cb.notEqual(root.get(fieldName)/*.as(String.class)*/, value)); 
//		}
		return cq;
	}
	
	public CriteriaQuery<T> inClause(String fieldName, /*Boolean inverseClause,*/ Object... values) {
		CriteriaQuery<T> cq = withCriteriaBuilder().createQuery(getEntityClass());  
		Root<T> root = cq.from(getEntityClass());
		cq.select(root);

		In<Object> in = withCriteriaBuilder().in(root.get(fieldName));

		for(Object val: values) {
			in.value(val);
		}
		cq.where(in);
		return cq;
	}
	
//	@SuppressWarnings("unchecked")
//	public CriteriaQuery<T> and(CriteriaQuery<T>... subClauses) {
//		CriteriaQuery<T> cq = withCriteriaBuilder().createQuery(getEntityClass());  
//		Root<T> root = cq.from(getEntityClass());
//		cq.select(root);
//		for (CriteriaQuery<T> subClause: subClauses) {
//			if (subClause != null) {
//				//System.out.println(subClause.getRestriction().
//				cq.where(withCriteriaBuilder().and(cq.getRestriction(), subClause.getRestriction()));
//			}
//		}
//		return cq;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public CriteriaQuery<T> or(CriteriaQuery<T>... subClauses) {
//		CriteriaQuery<T> cq = withCriteriaBuilder().createQuery(getEntityClass());  
//		Root<T> root = cq.from(getEntityClass());
//		cq.select(root);
//		for (CriteriaQuery<T> subClause: subClauses) {
//			if (subClause != null) {
//				cq.where(withCriteriaBuilder().or(cq.getRestriction(), subClause.getRestriction()));
//			}
//		}	
//		return cq;
//	}
	
	@Override
	public T findById(I id) {
		T result = null;     
		try {
			sessionManager.beginTransaction();
			result = (T) sessionManager.getSession().get(getEntityClass(), id, LockOptions.READ); //load(getEntityClass(), id, LockMode.READ);
			sessionManager.closeWithCommit();
		} catch (HibernateException he) {
			System.out.println("ERROR in findById() " + he.getMessage());
			sessionManager.closeWithRollback();
		}
		return result;
	}
	
	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> findBySQLQuery(String sql) {
		List<T> result = null;
		try {
			sessionManager.beginTransaction();
			SQLQuery<T> query = getSessionManager().getSession().createSQLQuery(sql);
			query.addEntity(getEntityClass());
			result = query.list();
			sessionManager.closeWithCommit();
		} catch (Exception e) {
			sessionManager.closeWithRollback();
			System.out.println("ERROR in findBySQLQuery() " + e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public void delete(T entityToDelete) {
		try {
			sessionManager.beginTransaction();
			sessionManager.getSession().delete(entityToDelete);
			sessionManager.closeWithCommit();
		} catch (Exception he) {
			sessionManager.closeWithRollback();
			System.out.println("ERROR in delete() " + he.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Serializable insert(T newEntity) {
		I returnedId = null;
		try {
			sessionManager.beginTransaction();
			returnedId = (I) sessionManager.getSession().save(newEntity);
			sessionManager.closeWithCommit();
		} catch (Exception e) {
			sessionManager.closeWithRollback();
			System.out.println("ERROR in insert() " + e.getMessage());
		}
		return returnedId;
	}

	@Override
	public T update(T newStateItem) {
		try {
			sessionManager.beginTransaction();
			sessionManager.getSession().merge(newStateItem);
			sessionManager.closeWithCommit();
		} catch (HibernateException he) {
			sessionManager.closeWithRollback();
			System.out.println("ERROR in update () " + he.getMessage());
		}
		return newStateItem;
	}

}
