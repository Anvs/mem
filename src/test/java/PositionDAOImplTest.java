import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.anvs.mem.dao.PositionDAO;
import com.anvs.mem.dao.PositionDAOImpl;
import com.anvs.mem.model.Position;

public class PositionDAOImplTest {
	Position forTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		forTest = new Position("For test");
	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public final void testSave() {
		PositionDAO testedObject = new PositionDAOImpl();
		testedObject.save(forTest);
	}

	@Test
	@Ignore
	public final void testGetById() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testGetFilteredSet() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testInsert() {
		fail("Not yet implemented"); // TODO
	}



}
