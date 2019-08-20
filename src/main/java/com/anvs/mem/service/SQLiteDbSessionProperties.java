 package com.anvs.mem.service;

import java.util.Properties;

public class SQLiteDbSessionProperties {
	private  Properties props;
// сделать статическим!
	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public SQLiteDbSessionProperties(Properties props) {
		this.props = props;
	}
	
	public SQLiteDbSessionProperties(String dbFileName) {
		props = new Properties();
		props.setProperty("show_sql", "true");
		props.setProperty("format_sql", "true");
		props.setProperty("dialect",  "org.hibernate.dialect.SQLiteDialect");
		props.setProperty("connection.driver_class", "org.sqlite.JDBC");
		props.setProperty("connection.url", dbFileName);
		props.setProperty("connection.username", "");
		props.setProperty("connection.password", "");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("mapping class", "com.anvs.mem.model.Company");
	}
	
}
