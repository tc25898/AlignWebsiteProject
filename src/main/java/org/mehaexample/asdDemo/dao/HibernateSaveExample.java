package org.mehaexample.asdDemo.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.mehaexample.asdDemo.model.EmployeeFirst;

public class HibernateSaveExample {

	public static void main(String[] args) {
		SessionFactory factory; 
 
		try {
			 
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         EmployeeFirst employee = getTestEmployee();
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		// Prep Work
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		
////		//save example - without transaction
//		Session session = sessionFactory.openSession();
////		Employee emp = getTestEmployee();
////		session.save(emp);
////		session.flush(); //address will not get saved without this
////		System.out.println("*****");
//		
////		//save example - with transaction
//		Transaction tx1 = session.beginTransaction();
//		Session session1 = sessionFactory.openSession();
//		Employee emp1 = getTestEmployee();
//		 session1.save(emp1);
////		System.out.println("2. Employee save called with transaction, id="+id1);
//		System.out.println("3. Before committing save transaction");
//		tx1.commit();
//		System.out.println("4. After committing save transaction");
//		System.out.println("*****");
		
		//// not use
//		//save example - existing row in table
//		Session session6 = sessionFactory.openSession();
//		Transaction tx6 = session6.beginTransaction();
//		Employee emp6 =  (Employee) session6.load(Employee.class, new Long(20));
//		
//		//update some data
//		System.out.println("Employee Details="+emp6);
//		emp6.setName("New Name");
//		emp6.getAddress().setCity("New City");
//		
//		long id6 = (Long) session6.save(emp6);
//		emp6.setName("New Name1"); // will get updated in database
//		System.out.println("5. Employee save called with transaction, id="+id6);
//		System.out.println("6. Before committing save transaction");
//		tx6.commit();
//		System.out.println("7. After committing save transaction");
//		System.out.println("*****");
		
		// Close resources
//		sessionFactory.close();
	}

	public static EmployeeFirst getTestEmployee() {
		EmployeeFirst emp = new EmployeeFirst();
		emp.setName("Test Emp");
		emp.setSalary(1000);
		
		return emp;
	}
}