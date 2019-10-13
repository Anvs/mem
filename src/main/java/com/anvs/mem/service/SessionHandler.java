package com.anvs.mem.service;

import org.hibernate.Session;

public interface SessionHandler {

	Session getEstablishedSession();

	void beginTransaction();

	void closeWithCommit();

	void closeWithRollback();

}