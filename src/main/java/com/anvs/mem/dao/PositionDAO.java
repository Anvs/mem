package com.anvs.mem.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.anvs.mem.model.Position;

/**
 * Provides CRUD operations for Position class
 * @author anvs
 *
 */
public interface PositionDAO {
		
		Position getById(final int id );
		
		List<Position> getFilteredSet(Criteria filter);
		
		void delete(Position positionToDelete);
		
		/* insert(...)
		 * Connect to DB
		 * Prepare insert statement
		 * Check operation status
		 * disconnect from DB
		 * 
		 * Handle errors
		 * */
		void insert(Position newPosition);

		void save(Position newStateItem);
}
