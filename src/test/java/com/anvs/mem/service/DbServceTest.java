/**
 * 
 */
package com.anvs.mem.service;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author anvs
 *
 */
public class DbServceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.anvs.mem.service.DbServce#connect()}.
	 */
	@Test
	public final void testConnect() {
		DbServce testServ = new DbServce();
//		try {
		Session ss = null;
		ss = testServ.connect();
		assertTrue(ss != null);
//		} 
//		catch (Exception e) {
//			
//		}
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.anvs.mem.service.DbServce#disconnect()}.
	 */
	@Test
	public final void testDisconnect() {
		fail("Not yet implemented"); // TODO
	}

}
