package org.mehaexample.asdDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mehaexample.asdDemo.model.Student;

public class StudentDao {
	
	
	public void connnectionToDatabase(){
		
	}

	public boolean deleteStudentRecord1(String nuid){
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
			String sql = "DELETE FROM student " +
					"WHERE nuid = '" + nuid + "' ";
			System.out.println("delete sql: " + sql);
			stmt.executeUpdate(sql);

		}catch(Exception ex){

		}
		return false;
	}

	public boolean ifNuidExists(String nuid){
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
			//STEP 4: Execute a query
			System.out.println("Updatig Student Record.......");
			String sql = "SELECT * from student "
					+ "where nuid = "+ nuid;
			System.out.println("sql = " + sql);
			ResultSet rs = stmt.executeQuery(sql);

			if(!rs.next()){
				rs.close();
				return false;
			}else {
				rs.close();
				return true;  
			}
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
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		
		return false;
	}//end main



	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
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
			ResultSet rs = stmt.executeQuery("select * from Student");

			while(rs.next()){
				Student x =new Student();
				System.out.println(rs.getInt("id"));
				//Retrieve by column name
				x.setId(rs.getInt("id"));
				x.setFirstName(rs.getString("firstname"));	  

				list.add(x);     
			}
			rs.close();

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

		return list;
	}


	public void updateStudentRecordDao(Student student){
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

			//STEP 4: Execute a query
			System.out.println("Updatig Student Record.......");
			String sql = "UPDATE student " + 
					"SET " +
					"firstName = '" + student.getFirstName() + "'," +
					"lastName = '" + student.getLastName() + "' " +
					"WHERE nuid = '"+ student.getNuid() + "' ";
			int updates = stmt.executeUpdate(sql);
			System.out.println("update staement = " + sql +  " , " + updates);

		}catch(SQLException se){
			System.out.println("exception12");
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			System.out.println("exception");
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main


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

	public void deleteStudentRecord(Student student){
		String sqlDeleteRecord = "DELETE FROM Registration " +
				"WHERE id =" + student.getId();

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
			stmt.executeUpdate(sqlDeleteRecord);

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
				"'"+student.getEnrollmentStatus()+ "'," + 
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
