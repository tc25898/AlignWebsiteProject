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
import javax.transaction.Transactional;

public class StudentDao {

	private static SessionFactory factory; 
	private static Session session;

	public StudentDao(){
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

		if(ifNuidExists(student.getNeuId())){
			System.out.println("student already exists!");
		}else{
			System.out.println("saving student in addStudentRecord");
			try {
				tx = session.beginTransaction();
				session.save(student);
				tx.commit();
			} catch (HibernateException e) {
				System.out.println("HibernateException: " + e);
				if (tx!=null) tx.rollback();
			} finally {
				session.close(); 
			}
		}
	}
	
	// added search student record using first name
	public List<Student> searchStudentRecord(String firstName) {
		org.hibernate.query.Query query = session.createQuery("from Student where firstName = :studentfirstName ");
		query.setParameter("studentfirstName", firstName);
		List<Student> list = query.list();
		return list;
	}
	
	// added search student record using first name
	public List<Student> searchSimilarStudents(String degree, String major) {
		org.hibernate.query.Query query = session.createQuery("from Student where degreeCandidacy = :degree and major = :major ");
		query.setParameter("degree", degree);
		query.setParameter("major", major);
		List<Student> list = query.list();
		return list;
	}

	public List<Student> getAllStudents(){
		org.hibernate.query.Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		return list;
	}

	public Student getStudentRecord(String nuid) {
		org.hibernate.query.Query query = session.createQuery("from Student where NeuId = :studentNuid ");
		query.setParameter("studentNuid", nuid);
		List list = query.list();
		if(list.size()==1){
			return (Student) list.get(0);
		}else{
			System.out.println("The list should contain only one student with a given nuid");
			return null;
		}
	}
	
	public void updateStudentRecordDaoByEmail(String email, Student student) {
		Transaction tx = null;
		String nuid = getNuidForEmail(email);
		if(ifNuidExists(nuid)){
			try{
				
				Session session = factory.openSession();
				tx = session.beginTransaction();
				
				String hql = "UPDATE Student set address = :studentAddress "  + 
						"WHERE nuid = :studentNuid";
				org.hibernate.query.Query query = session.createQuery(hql);
				query.setParameter("studentAddress", "Bellevue Meadows from Ecliplse");
				query.setParameter("studentNuid", nuid);
				int result = query.executeUpdate();
				System.out.println("Rows affected: " + result);
				tx.commit();
//				Session session = factory.openSession();
//				tx = session.beginTransaction();
//
//				String hqlUpdate = "update Student s set s.address = :newAddress where s.nuid = :studentNuid";
//				// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
//				int updatedEntities = session.createQuery( hqlUpdate )
//				        .setString( "newAddress", student.getAddress())
//				        .setString( "studentNuid", nuid )
//				        .executeUpdate();
//				tx.commit();
//				session.close();
//				tx = session.beginTransaction();
//				org.hibernate.query.Query query = session.createQuery("update Student set address = :studentAddress" +
//						" where nuid = :studentNuid");
//				query.setParameter("studentAddress", student.getAddress());
//				query.setParameter("studentNuid", nuid);
//				
//				int result = query.executeUpdate();
////				session.save(student);
//				tx.commit();
//				System.out.println("update = " + result);
//				//session.save(student);
				
			}catch (HibernateException e) {
				if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}
			
			
		}else{
			System.out.println("student id doesn't exists..");
		}
	}

	private String getNuidForEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStudentRecordDao(String nuid, Student student) {
		Transaction tx = null;
		if(ifNuidExists(nuid)){
			try{
				
				Session session = factory.openSession();
				tx = session.beginTransaction();
				
				String hql = "UPDATE Student set address = :studentAddress "  + 
						"WHERE nuid = :studentNuid";
				org.hibernate.query.Query query = session.createQuery(hql);
				query.setParameter("studentAddress", "Bellevue Meadows from Ecliplse");
				query.setParameter("studentNuid", nuid);
				int result = query.executeUpdate();
				System.out.println("Rows affected: " + result);
				tx.commit();
//				Session session = factory.openSession();
//				tx = session.beginTransaction();
//
//				String hqlUpdate = "update Student s set s.address = :newAddress where s.nuid = :studentNuid";
//				// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
//				int updatedEntities = session.createQuery( hqlUpdate )
//				        .setString( "newAddress", student.getAddress())
//				        .setString( "studentNuid", nuid )
//				        .executeUpdate();
//				tx.commit();
//				session.close();
//				tx = session.beginTransaction();
//				org.hibernate.query.Query query = session.createQuery("update Student set address = :studentAddress" +
//						" where nuid = :studentNuid");
//				query.setParameter("studentAddress", student.getAddress());
//				query.setParameter("studentNuid", nuid);
//				
//				int result = query.executeUpdate();
////				session.save(student);
//				tx.commit();
//				System.out.println("update = " + result);
//				//session.save(student);
				
			}catch (HibernateException e) {
				if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}
			
			
		}else{
			System.out.println("student id doesn't exists..");
		}
	}

	public int getIdFromNuid(String nuid){
		org.hibernate.query.Query query = session.createQuery("from Student where nuid = :studentNuid");
		query.setParameter("studentNuid", nuid);
		List list = query.list();
		Student student =  (Student) list.get(0);
		return student.getId();
	}
	
	public boolean deleteStudentRecord(String nuid){		
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Student student = session.get(Student.class, getIdFromNuid(nuid)); 
			System.out.println("Deleting student for nuid = " + nuid);
			session.delete(student); 
			tx.commit();
			if(ifNuidExists(nuid)){
				return false;
			}else{
				return true;
			}
		} catch (HibernateException e) {
			System.out.println("exceptionnnnnn");
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return true;
	}

	public boolean ifNuidExists(String nuid){
		try{
			System.out.println("Checking if an entered nuid exists or not.......");
			org.hibernate.query.Query query = session.createQuery("from Student where nuid = :studentNuid ");
			query.setParameter("studentNuid", nuid);
			List list = query.list();
			System.out.println("list size = " + list.size());
			if(list.size() == 1){
				return true;
			}
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}
		
		return false;
	}
}
