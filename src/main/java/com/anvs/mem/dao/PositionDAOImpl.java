package com.anvs.mem.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.anvs.mem.model.Company;
import com.anvs.mem.model.Position;
import com.anvs.mem.service.SessionHandlerImpl;

/**
 * Class provides CRUD operations for Position class
 * @author anvs
 *
 */
public class PositionDAOImpl extends HibernateDAO<Position, Long> {
	
	public PositionDAOImpl() {
		super(Position.class);
		setSessionManager(new SessionHandlerImpl());
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Position> findByName(String mask) {
//		CriteriaBuilder cb = getSessionManager()
//									.getSession()
//									.getCriteriaBuilder();
//		CriteriaQuery<Position> cq = cb.createQuery(getEntityClass());  
//		Root<Position> position = cq.from(getEntityClass());
//		cq.select(position);
//		//ParameterExpression<Position> pe;
//		cq.where(cb.like(position.get("name").as(String.class), mask)); //equal(positionot.get("name"),  mask));
//		List<Position> resultList;
//		Query q = getSessionManager().getSession().createQuery(cq);
//		resultList = q.getResultList();
//		return resultList;
//	}
	
	public List<Position> findByName(String mask) {
		return findWithCriteria(likeClause("name", mask));
	}

	@Override
	public List<Position> findByExample(Position example) {
		
		List<Position> result = null;
		CriteriaQuery<Position> cq = null;  
	
		if (example != null) {
			cq = withCriteriaBuilder().createQuery(getEntityClass());
			Root<Position> root = cq.from(getEntityClass());
			cq.select(root);
			Predicate whereCluase = withCriteriaBuilder().conjunction();
			
			if (example.getId() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("id"), example.getId());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getName() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("name").as(String.class), example.getName());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}

			cq.where(whereCluase); 
			Query q = getSessionManager().getSession().createQuery(cq);
			// TODO ПРи неудачном поиске возвращает не null
			result = q.getResultList();
		} else {
			result = findAll();
		}
		return result;
	}
}
