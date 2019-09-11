package com.anvs.mem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anvs.mem.model.Company;
import com.anvs.mem.service.DbServce;
import com.anvs.mem.service.SQLiteDbSessionProperties;
 
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	DbServce dbServ = new DbServce();
        SQLiteDbSessionProperties dbProps = new SQLiteDbSessionProperties("mem.db");
        SessionFactory sf = dbServ.buildSessionFactory(dbProps.getProps());
        Session s = sf.getCurrentSession();
        
        Company company = new Company("Test Co");
        s.beginTransaction();
        s.save(company);
        s.getTransaction().commit();
        
        dbServ.shutdown();
    }
}