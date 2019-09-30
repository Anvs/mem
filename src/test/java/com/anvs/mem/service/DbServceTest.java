/**
 * 
 */
package com.anvs.mem.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author anvs
 *
 */
public class DbServceTest {
	private DbServce testServ;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testServ = new DbServce();
	}

	/**
	 * Test method for {@link com.anvs.mem.service.DbServce#getEstablishedConnection()}.
	 */
	@Test
	public final void testgetEstablishedConnection() {
//		Session ss = null;
//		ss = testServ.getEstablishedConnection();
		assertNotNull(testServ.getEstablishedConnection());
		assertTrue(testServ.getEstablishedConnection().isConnected());
//		Transaction tran = testServ.getEstablishedConnection().getTransaction();
//		tran.begin();
//		tran.commit();
	}

	/**
	 * Test method for {@link com.anvs.mem.service.DbServce#disconnect()}.
	 */
	@Test
	public final void testDisconnect() {
		assertNotNull(testServ.getEstablishedConnection());
		testServ.disconnect();
	}

}
