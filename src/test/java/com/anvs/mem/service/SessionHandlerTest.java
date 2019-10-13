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
	private static SessionHandlerImpl sessionHandler;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		sessionHandler = new SessionHandlerImpl();
	}

	/**
	 * Test method for {@link com.anvs.mem.service.SessionHandlerImpl#getEstablishedSession()}.
	 */
	@Test
	public final void testGetEstablishedConnection() {
		assertNotNull(sessionHandler.getEstablishedSession());
		assertTrue(sessionHandler.getEstablishedSession().isConnected());
		sessionHandler.disconnect();
	}

	/**
	 * Test method for {@link com.anvs.mem.service.SessionHandlerImpl#disconnect()}.
	 */
	@Test
	public final void testTransactionRollback() {
		sessionHandler.getEstablishedSession();
		sessionHandler.getEstablishedSession();
		sessionHandler.beginTransaction();
		sessionHandler.closeWithRollback();
	}
	
	@Test
	public final void testTransactionCommit() {
		sessionHandler.getEstablishedSession();
		sessionHandler.getEstablishedSession();
		sessionHandler.beginTransaction();
		sessionHandler.closeWithCommit();;
	}
	
//	@After
//	public final void finalize() {
//		assertNull(sessionHandler.getEstablishedConnection());
//	}

}
