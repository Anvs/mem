package com.anvs.mem.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.anvs.mem.model.Company;
import com.anvs.mem.model.Employee;
import com.anvs.mem.model.Position;
import com.anvs.mem.service.SessionHandlerImpl;

public class EmployeeDAOImpl extends HibernateDAO<Employee, Long> {
	public EmployeeDAOImpl() {
		super(Employee.class);
		setSessionManager(new SessionHandlerImpl());
	}
	
	public List<Employee> findByFio(String mask) {
		return findWithCriteria(likeClause("fio", mask));
	}

	public List<Employee> findByCompany(Company company) {
		return findWithCriteria(equalClause("company", company));
	}

	public List<Employee> findByPosition(Position pos) {
		return findWithCriteria(equalClause("position", pos));
	}

	public List<Employee> findArchived(Boolean yes) {
		return findWithCriteria(equalClause("isArchived", ((yes == true) ? 1 : 0)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByExample(Employee example) {
		List<Employee> result = null;
		CriteriaQuery<Employee> cq = null;  
	
		if (example != null) {
			cq = withCriteriaBuilder().createQuery(getEntityClass());
			Root<Employee> root = cq.from(getEntityClass());
			cq.select(root);
			Predicate whereCluase = withCriteriaBuilder().conjunction();
			
			if (example.getId() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("id"), example.getId());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getFio() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("fio").as(String.class), example.getFio());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getPosition() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("position"), example.getPosition());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getCompany() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("company"), example.getCompany());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getCitizenship() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("citizenship").as(String.class), example.getCitizenship());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getPasspotPrefix() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("passpotPrefix").as(String.class), example.getPasspotPrefix());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getPassportNumber() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("passportNumber").as(String.class), example.getPassportNumber());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getPassportDepName() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("passportDepName").as(String.class), example.getPassportDepName());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getPassportDepCode() != null) {
				Predicate p = withCriteriaBuilder().like(root.get("passportDepCode").as(String.class), example.getPassportDepCode());
				whereCluase = withCriteriaBuilder().and(whereCluase, p); 
			}
			if (example.getPassportDate() != null) {
				Predicate p = withCriteriaBuilder().equal(root.get("passportDate"), example.getPassportDate());
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
