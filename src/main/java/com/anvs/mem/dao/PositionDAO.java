package com.anvs.mem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import com.anvs.mem.model.Position;

/**
 * Class provides CRUD operations for Position class
 * @author anvs
 *
 */
public class PositionDAO {
	
	public Position getPosition(final int id ) {
		
		return null;
	}
	
	public List<Position> getFilteredSet(Criteria filter) {
		List<Position> filteredSet = new ArrayList<Position>();
		return filteredSet;
	}
	
	public void delete(final int id ) {
		
	}
	
	public void delete(Position positionToDelete) {
		
	}
	
	public void insert(Position newPosition) {
		
	}
	
	public void insertAll(List<Position> newList) {
		
	}

}
