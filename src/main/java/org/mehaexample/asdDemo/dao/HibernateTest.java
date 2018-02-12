package org.mehaexample.asdDemo.dao;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mehaexample.asdDemo.model.Student;

public class HibernateTest {
	private static SessionFactory factory; 

	public static void main(String[] args) {
		try {
			// it will check the hibernate.cfg.xml file and load it
			// next it goes to all table files in the hibernate file and loads them
			factory = new Configuration().configure().buildSessionFactory();
			addStudentRecord("fn", "lname", "7624");
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}

	/* Method to CREATE an employee in the database */
	public static void addStudentRecord(String fname, String lname, String nuid){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			Student student = new Student();
			student.setFirstName(fname);
			student.setEmailId("foo@bar.com");
			student.setLastName(lname);
			student.setNuid(nuid);
			
//		 adding a record using hibaernamtw
			session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
}
