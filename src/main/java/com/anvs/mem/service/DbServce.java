package com.anvs.mem.service;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbServce {
//	private  Properties properties;
	private  SessionFactory sessionFactory;

	public  SessionFactory buildSessionFactory(Properties props) {
		return new Configuration().setProperties(props).buildSessionFactory();
	}
	
	public  void shutdown() {
		sessionFactory.close();
	}
}
