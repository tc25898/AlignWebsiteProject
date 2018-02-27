package org.mehaexample.asdDemo.dao;
/*
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

	public List<Student> getAllStudents(){
		System.out.println("reached dao");
		org.hibernate.query.Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		return list;
	}

	public Student getStudentRecord(String nuid) {
		org.hibernate.query.Query query = session.createQuery("from Student where NeuId = :studentNuid");
		query.setParameter("studentNuid", nuid);
		List list = query.list();
		System.out.println("The size is " + list.size()); 
		if(list.size()==1){
			return (Student) list.get(0);
		}else{
			System.out.println("The list should contain only one student with a given nuid");
			return null;
		}
	}

//	public Student getStudentRecord(String nuid) {
////		org.hibernate.query.Query query = session.createQuery("from Student where NeuId = :studentNuid");
//		org.hibernate.query.Query query = session.createQuery("from Student where Campus = :studentNuid");
//		query.setParameter("studentNuid", "SILICON_VALLEY");
//		List list = query.list();
//		System.out.println("The size is " + list.size()); 
//		if(list.size()==1){
//			return (Student) list.get(0);
//		}else{
//			System.out.println("The list should contain only one student with a given nuid");
//			return null;
//		}
//	}

	public Student getStudentRecordByEmailId(String email) {
		org.hibernate.query.Query query = session.createQuery("from Student where Email = :studentEmail");
		query.setParameter("studentEmail", email);
		List list = query.list();
		if(list.size()==1){
			return (Student) list.get(0);
		}else{
			System.out.println("The list should contain only one student with a given email or the student doesn't exists ");
			return null;
		}
	}

	public void addStudentRecord(Student student) {		
		Transaction tx = null;
		System.out.println("saving student in addStudentRecord");
		try {
			tx = session.beginTransaction();
			System.out.println("State is ====== " + student.getState());
			session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
			if (tx!=null) tx.rollback();
		} finally {
			session.close(); 
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


//	public void updateStudentRecordDaoByEmail(String email, Student student) {
//		Transaction tx = null;
//		if(ifNuidExists(neuid)){
//			System.out.println("updating student in addStudentRecord");
//			try {
//				tx = session.beginTransaction();
//				System.out.println("State is ====== " + student.getState());
//				int studentId = getIdFromNuid(neuid);
//				student.setId(studentId); 
//				session.update(student);
//				tx.commit();
//			} catch (HibernateException e) {
//				System.out.println("HibernateException: " + e);
//				if (tx!=null) tx.rollback();
//			} finally {
//				session.close(); 
//			}
//		}else{
//			System.out.println("student id doesn't exists..");
//		}
//	}

	private String getNuidForEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStudentRecordDao(String neuid, Student student) {
		Transaction tx = null;
		if(ifNuidExists(neuid)){
			System.out.println("updating student in addStudentRecord");
			try {
				tx = session.beginTransaction();
				System.out.println("State is ====== " + student.getState());
				int studentId = getIdFromNuid(neuid);
				student.setId(studentId); 
				session.clear();
				session.saveOrUpdate(student);
				tx.commit();
			} catch (HibernateException e) {
				System.out.println("HibernateException: " + e);
				if (tx!=null) tx.rollback();
			} finally {
				session.close(); 
			}
		}else{
			System.out.println("student id doesn't exists..");
		}
	}

	public int getIdFromNuid(String nuid){
		org.hibernate.query.Query query = session.createQuery("from Student where NeuId = :studentNuid");
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
			System.out.println("Deleting student for NeuId = " + nuid);
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
			org.hibernate.query.Query query = session.createQuery("from Student where NeuId = :studentNuid ");
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
*/