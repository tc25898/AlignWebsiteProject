package org.mehaexample.asdDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mehaexample.asdDemo.model.Student;

public class StudentDao {
	
	public int getStudentsCount() {		
		Connection conn = null;
		 Statement stmt = null;
		 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 final String DB_URL = "jdbc:mysql://localhost/STUDENTS2";
		
		 //  Database credentials
		  final String USER = "root";
		  final String PASS = "Turkey#786";
		 try{
			    //STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connection successful");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from Student");
		    rs.next();
		    int count = rs.getInt(1);
		    
		    return count;
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		try{
		   if(stmt!=null)
		      stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
		   if(conn!=null)
		      conn.close();
		}catch(SQLException se){
		   se.printStackTrace();
		}//end finally try
		 }
		return -1;
	}
	
	public void addStudentRecord(Student student){
	String sqlInsertRecord = "INSERT INTO Student " + 
				 "VALUES (" + 
			"'"+student.getId()+ "'," + 
			"'"+student.getNUID()+ "'," + 
			"'"+student.getFirstName()+ "'," + 
			"'"+student.getLastName()+ "'," + 
			"'"+student.getEmailId()+ "'," + 
			"'"+student.getGender()+ "'," + 
			"'"+student.getPhoneNumber()+ "'," + 
			"'"+student.getStartTerm()+ "'," + 
			"'"+student.getEnrollmentstatus()+ "'," + 
			"'"+student.getMajor()+ "'," + 
			"'"+student.getDegree()+ "'," + 
			"'"+student.getCampus()+ "'," + 
			"'"+student.getCitizenshipStatus()+ "'" +			
			")";
	
	 Connection conn = null;
	 Statement stmt = null;
	 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 final String DB_URL = "jdbc:mysql://localhost/STUDENTS2";

	 //  Database credentials
	  final String USER = "root";
	  final String PASS = "Turkey#786";
	 try{
		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connection successful");
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sqlInsertRecord);
		    
		    System.out.println("Created table in given database...");
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		    try{
		       if(stmt!=null)
		          stmt.close();
		    }catch(SQLException se2){
		    }// nothing we can do
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }//end finally try
		 }
	}
}
