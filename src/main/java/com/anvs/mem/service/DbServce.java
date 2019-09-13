package com.anvs.mem.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbServce {
	
	private final static String PROPERTIES_FILENAME = "";
	
	private static SessionFactory dbConnector = null;
	
	private static Session connection = null;
	
	static {
		Properties configProperties = new Properties();
	
		try {
			FileInputStream propertyFile = new FileInputStream(PROPERTIES_FILENAME);
			configProperties.load(propertyFile);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
		
		Configuration config = new Configuration();
		config.addProperties(configProperties);
		
		dbConnector = config.buildSessionFactory();
		
//		StandardServiceRegistryBuilder connectBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
//		dbConnector = config.buildSessionFactory(connectBuilder.build());
	}

//	public  SessionFactory getDbConnector() {
//		return dbConnector;
//	}
	
	public Session connect() {
		if (connection == null) connection = dbConnector.openSession();
		
		return connection;
	}

	public void disconnect() {
		if (connection.isOpen()) connection.close();
	}
}
