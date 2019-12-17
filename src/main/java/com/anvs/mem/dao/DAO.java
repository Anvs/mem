package com.anvs.mem.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> {
		
	List<T> findAll();		
	
	T findById(final I id);
	
	List<T> findByExample(T example);
		
	List<T> findBySQLQuery(String sql);
		
	void delete(T  entityToDelete);
		
		/* insert(...)
		 * Connect to DB
		 * Prepare insert statement
		 * Check operation status
		 * disconnect from DB
		 * 
		 * Handle errors
		 * */
	Serializable insert(T newEntity);
		
	T update(T newStateItem);

}
