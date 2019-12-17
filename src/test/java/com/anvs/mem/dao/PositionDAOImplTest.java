package com.anvs.mem.dao;
import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.anvs.mem.dao.PositionDAOImpl;
import com.anvs.mem.model.Company;
import com.anvs.mem.model.Position;
import com.anvs.mem.service.SessionHandler;
import com.anvs.mem.service.SessionHandlerImpl;

public class PositionDAOImplTest {
	private static Position testEntity;
	
	//private static DAO<Position, Long> testDaoInstance = null;
	private static PositionDAOImpl testDaoInstance = null;
	private static Long persistId; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDaoInstance = new PositionDAOImpl();
		testEntity = new Position("For test");
		persistId = (Long) testDaoInstance.insert(testEntity);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDaoInstance.delete(testEntity);
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public final void testUpdate() {
		testEntity = testDaoInstance.findById(persistId);
		testEntity.setName(testEntity.getName() + " updated");
		testDaoInstance.update(testEntity);
		assertEquals("For test updated", testDaoInstance.findById(persistId).getName());
	}

	@Test
	public final void testFindById() {
		assertNotNull(testDaoInstance.findById(persistId));
	}
	
	@Test
	public void testFindAll() {
		List<Position> resultList = null;
		resultList = testDaoInstance.findAll();
		assertNotNull(resultList);
		assertNotEquals(0, resultList.size()); 
	}
	
@Test
	public final void testFindByQuery() {
		Position p_A = new Position("A");
		Position p_B = new Position("B"); 
		Position p_C = new Position("C");
		
		testDaoInstance.insert(p_A);
		testDaoInstance.insert(p_B);
		testDaoInstance.insert(p_C);
		
		List<Position> p_filtered = null;
		String sql = "select * from salaried_position where descr = 'B'";
		try {
			p_filtered = testDaoInstance.findBySQLQuery(sql);
			assertNotNull(p_filtered);			
		} catch(Exception e) {
			System.out.println("ERROR in testFindByQuery() " + e.getMessage());
		} finally {
			p_filtered.clear();
			p_filtered = null;
			testDaoInstance.delete(p_A);
			testDaoInstance.delete(p_B);
			testDaoInstance.delete(p_C);			
		}
			
	}
	@Test
	public final void testFindByName() {
		Position p_A = new Position("D");
		Position p_B = new Position("E"); 
		Position p_C = new Position("F");
		
		testDaoInstance.insert(p_A);
		testDaoInstance.insert(p_B);
		testDaoInstance.insert(p_C);
		
		List<Position> p_filtered = null;
		try {
			p_filtered = testDaoInstance.findByName("E");
			assertNotNull(p_filtered);	
			assertTrue(p_filtered.size() > 0);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		} finally {
			p_filtered.clear();
			p_filtered = null;
			testDaoInstance.delete(p_A);
			testDaoInstance.delete(p_B); 
			testDaoInstance.delete(p_C);			
		}
	}
	
	@Test
	public void testFingByExample() {
		Position example = new Position();
		example.setName("Dock%");
		List<Position> results = new ArrayList<>();
		results = testDaoInstance.findByExample(example);
		assertTrue(results.size() > 0);
		results.clear();
		example.setName("invalid_value%");
		results = testDaoInstance.findByExample(example);
		assertTrue(results.size() == 0);
	}	

	@Test
	public final void testDelete() {
		Position entityToDelete = new Position("Must be deleted");
		Serializable id = testDaoInstance.insert(entityToDelete);
		assertNotNull(id);
		entityToDelete = testDaoInstance.findById((Long) id);
		testDaoInstance.delete(entityToDelete);
		SessionHandler handler = new SessionHandlerImpl();
		assertFalse(handler.getSession().contains(entityToDelete));
		handler.getSession().disconnect();
	}

}
