package com.anvs.mem.service;

import java.util.Optional;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.secure.spi.PermissibleAction;

public class DbServce {
	private static final String PROPERTIES_FILENAME = "";
	private static  Properties configProperties;
	private static SessionFactory dbConnector = null;

	static {
		configProperties = new Properties();
		//configProperties.
		Configuration config = new Configuration().setProperties(configProperties);
		dbConnector = config.buildSessionFactory();
	}
	
	public  void closeDBConnector() {
		dbConnector.close();
	}

	Session openSession() throws IllegalStateException {
		Session sess = null;
		if (dbConnector == null) {
			throw new IllegalStateException("SessionFactory is not instanced."); 
		}
		else sess = dbConnector.openSession();
				
		return sess;
	}

	void closeSession() {
			
		
	}
}
