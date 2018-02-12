package org.mehaexample.asdDemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mehaexample.asdDemo.model.Student;

public class StudentDaoHibernate {
	
	private static SessionFactory factory; 
	private static Session session;

	public StudentDaoHibernate(){
		try {
			// it will check the hibernate.cfg.xml file and load it
			// next it goes to all table files in the hibernate file and loads them
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}

	public void addStudentRecord(Student student) {		
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public List<Student> getAllStudents(){
		org.hibernate.query.Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		return list;
	}
	
	public Student getStudentRecord(String nuid) {
		org.hibernate.query.Query query = session.createQuery("from Student where nuid = :studentNuid ");
		query.setParameter("studentNuid", nuid);
		List list = query.list();
		if(list.size()==1){
			return (Student) list.get(0);
		}else{
			System.out.println("The list should contain only one student with a given nuid");
			return null;
		}
	}

	public boolean ifNuidExists(String nuid){
		try{
			System.out.println("Checking if an entered nuid exists or not.......");
			org.hibernate.query.Query query = session.createQuery("from Student where nuid = :studentNuid ");
			query.setParameter("studentNuid", nuid);
			List list = query.list();
			if(list.isEmpty()){
				return false;
			}else {
				return true;  
			}
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}

		return false;
	}
}
