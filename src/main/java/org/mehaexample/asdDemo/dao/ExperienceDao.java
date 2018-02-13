package org.mehaexample.asdDemo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mehaexample.asdDemo.model.Experience;
import org.mehaexample.asdDemo.model.PriorEducation;

public class ExperienceDao {
	
	private static SessionFactory factory; 
	private static Session session;
	
	public ExperienceDao(){
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
	
	public List<Experience> getAllExperiences() {
		org.hibernate.query.Query query = session.createQuery("from Experience");
		List<Experience> list = query.list();  
		return list;
	}
	
	public List<Experience> getExperience(String nuid) {
		org.hibernate.query.Query query = session.createQuery("from Experience where nuid = :studentNuid");
		System.out.println("nuid here: " + nuid);
		query.setParameter("studentNuid", nuid);
		List<Experience> list = query.list();  
		return list;
	}

	public void addExperience(String nuid, Experience experience) {
		Transaction tx = null;
		StudentDao studentDaoHibernate = new StudentDao();

		if(studentDaoHibernate.ifNuidExists(nuid)){
			try {
				tx = session.beginTransaction();
				session.save(experience);
				tx.commit();
			} catch (HibernateException e) {
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
