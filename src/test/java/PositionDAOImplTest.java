import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.anvs.mem.dao.DAO;
import com.anvs.mem.dao.PositionDAOImpl;
import com.anvs.mem.model.Position;

public class PositionDAOImplTest {
	private static Position testEntity;
	
	private static DAO<Position> testDaoObject = null;
	private static Long persistId = null; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDaoObject = new PositionDAOImpl();
		testEntity = new Position("For test");
		persistId = (Long) testDaoObject.insert(testEntity);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testDaoObject.delete(testEntity);
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public final void testSave() {
		testEntity.setName(testEntity.getName() + " updated");
		testDaoObject.update(testEntity);
		assertEquals("For test updated", testDaoObject.findById(persistId));
	}

	@Test
	public final void testGetById() {
		assertNotNull(testDaoObject.findById(persistId));
	}

	@Test
	@Ignore
	public final void testGetFilteredSet() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDelete() {
		testEntity = new Position("Must be deleted");
		Serializable id = testDaoObject.insert(testEntity);
		testEntity = testDaoObject.findById((Long) id);
		testDaoObject.delete(testEntity);
		assertEquals("", testDaoObject.findById((Long) id).getName());
	}

	@Test
	public final void testInsert() {
		testEntity = new Position("For test");
		assertNotNull(testDaoObject.insert(testEntity));
		testDaoObject.delete(testEntity);
	}



}
