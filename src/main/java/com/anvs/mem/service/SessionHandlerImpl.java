package com.anvs.mem.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.anvs.mem.Messages;
//import com.anvs.mem.model.Position;
//import com.anvs.mem.model.Company;
import com.anvs.mem.model.*;

public class SessionHandlerImpl implements SessionHandler {
	
	private final static String PROPERTIES_FILENAME = "config/db_sqlite.prop";
	//private final static String PROPERTIES_FILENAME = "config/db_sqlite_win.prop";
	
	private static SessionFactory dbConnector = null;
	
	private static Session session = null;
	
	static {
		Properties configProperties = new Properties();
		try (FileInputStream propertyFile = new FileInputStream(PROPERTIES_FILENAME)) {
			configProperties.load(propertyFile);
        } catch (FileNotFoundException fnfe) {
            System.err.println(Messages.PROPERPIES_FILENOTFOUND);
        } catch (IOException ioe) {
        	System.err.println(Messages.PROPERPIES_READERROR);
			ioe.printStackTrace();
		} 
		
		Configuration config = new Configuration();
		config.addProperties(configProperties);
		config.addAnnotatedClass(Position.class);
		config.addAnnotatedClass(Company.class);
		config.addAnnotatedClass(Employee.class);
		
		StandardServiceRegistryBuilder connectBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		dbConnector = config.buildSessionFactory(connectBuilder.build());
	}

	public Session getSession() {
		try {
			if (session == null) session = dbConnector.openSession();
		} catch (HibernateException he) {
			System.err.println(Messages.SESSIONHANDLER_GETSESSION_ERROR);
			System.err.println(he.getMessage());
		}
		return session;
	}

	public void disconnect() {
		try {
			if (session.isOpen()) { 
				session.close();
			}
		} catch (HibernateException he) {
			System.out.println(Messages.SESSIONHANDLER_DISCONNECT_ERROR);
			System.out.println(he.getMessage());
		} catch (NullPointerException npe) {
			System.out.println(Messages.SESSIONHANDLER_DISCONNECT_ERROR);
			System.out.println(npe.getMessage());
		} finally {
			session = null;	
		}
	}
	
	public void beginTransaction() {
		this.getSession().beginTransaction();
	}
	
	public void closeWithCommit() {
		this.getSession().getTransaction().commit();
		this.disconnect();
	}
	
	public void closeWithRollback() {
		this.getSession().getTransaction().rollback();
		this.disconnect();
	}
}
