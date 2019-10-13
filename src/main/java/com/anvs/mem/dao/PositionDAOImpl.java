package com.anvs.mem.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import com.anvs.mem.model.Position;
import com.anvs.mem.service.SessionHandler;
import com.anvs.mem.service.SessionHandlerImpl;

/**
 * Class provides CRUD operations for Position class
 * @author anvs
 *
 */
public class PositionDAOImpl implements DAO<Position, Long> {
	
	private SessionHandler persistance = new SessionHandlerImpl();
	
	public Position getById(final Long id ) {
		Position result = new Position();                                                                                          
		persistance.beginTransaction();
		persistance.getEstablishedSession().load(result, id);
		persistance.closeWithCommit();
		return result;
	}
	
	public List<Position> findWithFilter(Criteria filter) {
		
		List<Position> foundSet = null;// = new ArrayList<Position>();
		foundSet = filter.list();
		return foundSet;
	} 
	
	public void delete(Position positionToDelete) {
		persistance.beginTransaction();
		persistance.getEstablishedSession().delete(positionToDelete);
		persistance.closeWithCommit();
	}
	
	public Serializable insert(Position newPosition) {
		/*		Filter
		 * Connect to DB
		 * Prepare insert statement
		 * Check operation status
		 * disconnect from DB
		 * 
		 * Handle errors
		 * */
		Long returnedId = null;
		persistance.beginTransaction();
		returnedId = (Long) persistance.getEstablishedSession().save(newPosition);
		persistance.closeWithCommit();
		return returnedId;
		
	}

	public Position update(Position newStateItem) {
		Position savedInstance = null;
		// TODO: check existing of newStateItem
		persistance.beginTransaction();
		savedInstance = (Position) persistance.getEstablishedSession().merge(newStateItem);
		persistance.closeWithCommit();
		return savedInstance;
	}

	public Position findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Position> findWithFilter(Position exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
