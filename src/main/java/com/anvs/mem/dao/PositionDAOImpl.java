package com.anvs.mem.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

import com.anvs.mem.model.Position;


public class PositionDAOImpl implements PositionDAO {
	
	public Position getById(final int id ) {
		
		return null;
	}
	
	public List<Position> getFilteredSet(Criteria filter) {
		List<Position> filteredSet = new ArrayList<Position>();
		return filteredSet;
	}
	
	public void delete(Position positionToDelete) {

	}
	
	public void insert(Position newPosition) {
		/*
		 * Connect to DB
		 * Prepare insert statement
		 * Check operation status
		 * disconnect from DB
		 * 
		 * Handle errors
		 * */
		
	}
	
	public void save(Position newStateItem) {
		
	}

}
