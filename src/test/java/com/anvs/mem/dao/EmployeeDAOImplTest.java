package com.anvs.mem.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import java.time.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.anvs.mem.model.Company;
import com.anvs.mem.model.Employee;
import com.anvs.mem.model.Position;

public class EmployeeDAOImplTest {
	private static EmployeeDAOImpl daoInstance;
	private static Employee entity;
	private static Position pos;
	private static Company comp;
	private static Long entityId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoInstance = new EmployeeDAOImpl();
		PositionDAOImpl daoPosition = new PositionDAOImpl();
		CompanyDAOImpl daoCompany = new CompanyDAOImpl();
		
		pos = (Position) daoPosition.findById(57L);
		if (pos == null) {
			pos = new Position("Docker");
			daoPosition.insert(pos);
		}
		
		comp = daoCompany.findById(1L);
		if (comp == null) {
			comp = new Company("IEK GROUP");
			daoCompany.insert(comp);
		}
		
		Calendar dt = new GregorianCalendar(2010, 10, 21);
		dt.add(Calendar.HOUR, 0);
		dt.add(Calendar.MINUTE, 10);
		dt.add(Calendar.SECOND, 0);
		//Date dt = new Date(4652186L);
		entity = new Employee("Иванов Иван Ильич"
								, comp
								, pos
								, false
								, "Russia"
								, "1234"
								, "567890"
								, "MVD"
								, "02"
								, dt);
		
		entityId = (Long) daoInstance.insert(entity);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoInstance.delete(entity);
	}

	@Test
	public void testFindByFio() {
		List<Employee> resultList = null;
		resultList = daoInstance.findByFio("Иванов%");
		assertTrue(resultList.size() > 0);
		resultList.clear();
		resultList = null;
	}

	@Test
	public void testFindByCompany() {
		assertTrue(daoInstance.findByCompany(comp).size() > 0);
	}

	@Test
	public void testFindByPosition() {
		assertTrue(daoInstance.findByPosition(pos).size() > 0);
	}

	@Test
	public void testFindArchived() {
		assertTrue(daoInstance.findArchived(false).size() > 0);
		assertFalse(daoInstance.findArchived(true).size() > 0);
	}

	@Test
	public void testFindAll() {
		List<Employee> resultList;
		resultList = daoInstance.findAll();
		assertTrue(resultList.size() > 0);
		resultList.clear();
		resultList = null;
	}

	@Test
	public void testFindById() {
		assertNotNull(daoInstance.findById(entityId));
	}

	@Test
	public void testFindBySQLQuery() {
		List<Employee> resultList;
		String sql = "select * from salaried_persons";
		resultList = daoInstance.findBySQLQuery(sql);
		assertTrue(resultList.size() > 0);
		resultList.clear();
		resultList = null;
	}

	@Test
	public void testDelete() {
		Employee instanceForDelete = new Employee(entity.getFio()
											, entity.getCompany()
											, entity.getPosition()
											, entity.isArchived()
											, entity.getCitizenship()
											, entity.getPasspotPrefix()
											, entity.getPassportNumber()
											, entity.getPassportDepName()
											, entity.getPassportDepCode()
											, entity.getPassportDate());
		instanceForDelete.setFio(entity.getFio() + " test delete");
		daoInstance.insert(instanceForDelete);
		assertTrue(daoInstance.findByFio("%test delete%").size() > 0);
		daoInstance.delete(instanceForDelete);
		assertFalse(daoInstance.findByFio("%test delete%").size() > 0);	
	}

	@Test
	@Ignore
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
