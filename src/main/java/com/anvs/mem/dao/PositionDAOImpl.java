package com.anvs.mem.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import com.anvs.mem.model.Position;
import com.anvs.mem.service.DbServce;

/**
 * Class provides CRUD operations for Position class
 * @author anvs
 *
 */
public class PositionDAOImpl implements PositionDAO {
	
	private DbServce service = new DbServce();
	
	public Position getById(final Long id ) {
		Position result = null;//new Position();
		service.getEstablishedConnection().load(result, id);
		service.disconnect();
		return result;
	}
	
	public List<Position> getFilteredSet(Criteria filter) {
		List<Position> filteredSet = new ArrayList<Position>();
		return filteredSet;
	}
	
	public void delete(Position positionToDelete) {
		service.getEstablishedConnection().delete(positionToDelete);
		service.disconnect();
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
		service.getEstablishedConnection().save(newPosition);
		service.disconnect();
		
	}

	public void save(Position newStateItem) {
		// TODO: check existing of newStateItem
		
		service.getEstablishedConnection().save(newStateItem);
		service.disconnect();
	}

}
