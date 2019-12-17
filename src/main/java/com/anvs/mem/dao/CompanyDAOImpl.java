package com.anvs.mem.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.anvs.mem.model.Company;
import com.anvs.mem.service.SessionHandlerImpl;

public class CompanyDAOImpl extends HibernateDAO<Company, Long> {
	
	public CompanyDAOImpl() {
		super(Company.class);
		setSessionManager(new SessionHandlerImpl());
	}
	
	public List<Company> findByName(String mask) {
		return findWithCriteria(likeClause("name", mask)); 
	}
	
	public List<Company> findByEmail(String mask) {
		return findWithCriteria(likeClause("broadcastEmail", mask));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findByExample(Company example) {
		
		List<Company> result = null;
		CriteriaQuery<Company> cq = null;  
	
		if (example != null) {
			cq = withCriteriaBuilder().createQuery(getEntityClass());
			Root<Company> root = cq.from(getEntityClass());
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
			if (example.getDinnerLimitInMinutes() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("dinnerLimitInMinutes"), example.getDinnerLimitInMinutes());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getBroadcastEmail() != null ) {
				Predicate p = withCriteriaBuilder().like(root.get("broadcastEmail").as(String.class), example.getBroadcastEmail());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.isLimitCheck() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("limitCheck"), example.isLimitCheck());
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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Company> findByExample(Company example) {
//		//TODO Переписать с Optional<Company>
//		List<Company> result = null;
//		
//		if (example != null) {
//			CriteriaQuery<Company> clauses;
//			clauses = withCriteriaBuilder().createQuery(getEntityClass());
//			Root<Company> root = clauses.from(getEntityClass());
//			clauses.select(root);
////			List<CriteriaQuery<Company>> clauses = new ArrayList<>();
////			if (example.getId() != null) {
////				clauses.add(equalClause("id", example.getId())); 
////			}
////			if (example.getName() != null) {
////				clauses.add(likeClause("name", example.getName()));
////			}
////			if (example.getDinnerLimitInMinutes() != null) {
////				clauses.add(equalClause("dinnerLimitInMinutes", example.getDinnerLimitInMinutes()));
////			}
////			if (example.getBroadcastEmail() != null ) {
////				clauses.add(likeClause("broadcastEmail", example.getBroadcastEmail()));
////			}
////			if (example.isLimitCheck() != null) {
////				clauses.add(equalClause("limitCheck", example.isLimitCheck()));
////			}
//			
//			clauses = example.getId() != null ? equalClause("id", example.getId()) : clauses;
//			clauses = example.getName() != null ? and(clauses, likeClause("name", example.getName())) : clauses;
//			clauses = example.getDinnerLimitInMinutes() != null ? and(clauses, equalClause("dinnerLimitInMinutes", example.getDinnerLimitInMinutes())) : clauses;
//			clauses = example.getBroadcastEmail() != null ? and(clauses, likeClause("broadcastEmail", example.getBroadcastEmail())) : clauses;
//			clauses = example.isLimitCheck() != null ? and(clauses, equalClause("limitCheck", example.isLimitCheck())) : clauses;
//
//			result = findWithCriteria(clauses);
//		} else {
//			result = findAll();
//		}
//		
//		return result;
//	}
}
