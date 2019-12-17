package com.anvs.mem.service;

import org.hibernate.Session;

public interface SessionHandler {

	Session getSession();

	void beginTransaction();

	void closeWithCommit();

	void closeWithRollback();

}