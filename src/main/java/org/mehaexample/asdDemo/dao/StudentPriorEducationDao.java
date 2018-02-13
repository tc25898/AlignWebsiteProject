package org.mehaexample.asdDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mehaexample.asdDemo.model.PriorEducation;
import org.mehaexample.asdDemo.model.Student;

public class StudentPriorEducationDao {

	private static SessionFactory factory; 
	private static Session session;
	
	public StudentPriorEducationDao(){
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
	
	public List<PriorEducation> getPriorEducation(String nuid) {
		org.hibernate.query.Query query = session.createQuery("from PriorEducation where nuid = :studentNuid");
		System.out.println("nuid here: " + nuid);
		query.setParameter("studentNuid", nuid);
		List<PriorEducation> list = query.list();  
		return list;
	}



	public void addPriorEducation(String nuid, PriorEducation priorEducation) {
		Transaction tx = null;
		StudentDaoHibernate studentDaoHibernate = new StudentDaoHibernate();
		System.out.println(priorEducation.getDegreeLevel());
		if(studentDaoHibernate.ifNuidExists(nuid)){
			try {
				tx = session.beginTransaction();
				session.save(priorEducation);
				tx.commit();
			} catch (HibernateException e) {
				System.out.println("exc................");
				if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			} finally {
				session.close(); 
			}
		}else{
			System.out.println("The student with a given nuid doesn't exists");
		}
	}

}
