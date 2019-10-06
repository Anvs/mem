/**
 * 
 */
package com.anvs.mem.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author anvs
 *
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionHandlerTest {
	private static SessionHandler sessionHandler;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		sessionHandler = new SessionHandler();
	}

	/**
	 * Test method for {@link com.anvs.mem.service.SessionHandler#getEstablishedConnection()}.
	 */
	@Test
	public final void testGetEstablishedConnection() {
		assertNotNull(sessionHandler.getEstablishedConnection());
		assertTrue(sessionHandler.getEstablishedConnection().isConnected());
		sessionHandler.disconnect();
	}

	/**
	 * Test method for {@link com.anvs.mem.service.SessionHandler#disconnect()}.
	 */
	@Test
	public final void testTransactionRollback() {
		sessionHandler.getEstablishedConnection();
		sessionHandler.getEstablishedConnection();
		sessionHandler.beginTransaction();
		sessionHandler.closeWithRollback();
	}
	
	@Test
	public final void testTransactionCommit() {
		sessionHandler.getEstablishedConnection();
		sessionHandler.getEstablishedConnection();
		sessionHandler.beginTransaction();
		sessionHandler.closeWithCommit();;
	}
	
//	@After
//	public final void finalize() {
//		assertNull(sessionHandler.getEstablishedConnection());
//	}

}
