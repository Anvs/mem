package com.anvs.mem.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.anvs.mem.Messages;


public class DbServce {
	
	private final static String PROPERTIES_FILENAME = "config/db_sqlite.prop";
	
	private static SessionFactory dbConnector = null;
	
	private static Session connection = null;
	
	static {
		Properties configProperties = new Properties();
	
		try {
			FileInputStream propertyFile = new FileInputStream(PROPERTIES_FILENAME);
			configProperties.load(propertyFile);
			propertyFile.close();
        } catch (IOException e) {
            System.err.println(Messages.PROPERPIES_FILENOTFOUND);
        }
		
		Configuration config = new Configuration();
		config.addProperties(configProperties);
		
		//dbConnector = config.buildSessionFactory();
		
		StandardServiceRegistryBuilder connectBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		dbConnector = config.buildSessionFactory(connectBuilder.build());
	}

//	public  SessionFactory getDbConnector() {
//		return dbConnector;
//	}
	
	public Session getEstablishedConnection() {
		if (connection == null) connection = dbConnector.openSession();
		
		return connection;
	}

	public void disconnect() {
		if (connection.isOpen()) connection.close();
	}
}
