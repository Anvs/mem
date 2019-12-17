package com.anvs.mem.dao;

import static org.junit.Assert.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.anvs.mem.model.Company;
import com.anvs.mem.dao.CompanyDAOImpl;


public class CompanyDAOImplTest extends CompanyDAOImpl {
	private static Company testEntity;
	private static CompanyDAOImpl testDaoInstance = null;
	private static Long persistId; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDaoInstance = new CompanyDAOImpl();
		testEntity = new Company("Test Company", 30, true, "e@mail.com");
		persistId = (Long) testDaoInstance.insert(testEntity);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDaoInstance.delete(testEntity);
	}

	@Test
	@Ignore
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByEmail() {
		//CompanyDAOImpl foundInstance;
		String expession = "%mail.c%";
		List<Company> results = new ArrayList<>();
		results = testDaoInstance.findByEmail("ignore expr");
		assertTrue(results.size() == 0);
		results = testDaoInstance.findByEmail(expession);
		assertTrue(results.size() > 0);
	}
	
	@Test
	public void testFingByExample() {
		Company example = new Company();
		example.setName("IEK%");
		example.setBroadcastEmail("anov.smtp@gmail.com");
		List<Company> results = new ArrayList<>();
		results = testDaoInstance.findByExample(example);
		assertTrue(results.size() > 0);
		results.clear();
		example.setBroadcastEmail("wrong_value");
		results = testDaoInstance.findByExample(example);
		assertTrue(results.size() == 0);
	}

	@Test
	public void testFindAll() {
		List<Company> results = new ArrayList<>();
		results = testDaoInstance.findAll();
		assertTrue(results.size() > 0);
	}

	@Test
	@Ignore
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		testEntity = testDaoInstance.findById(persistId);
		testEntity.setName(testEntity.getName() + " updated");
		testDaoInstance.update(testEntity);
		assertEquals("Test Company updated", testDaoInstance.findById(persistId).getName());

	}

}
