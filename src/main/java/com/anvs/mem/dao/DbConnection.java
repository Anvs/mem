package com.anvs.mem.dao;

public interface DbConnection {
	boolean init();
	void close();
}
