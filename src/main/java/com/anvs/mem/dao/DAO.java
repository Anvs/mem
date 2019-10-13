package com.anvs.mem.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> {
		
		T findById(final I id);
		
		List<T> findAll();
		
		List<T> findWithFilter(T exampleInstance);
		
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
