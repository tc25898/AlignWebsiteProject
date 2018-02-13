package utils;

//STEP 1. Import required packages
import java.sql.*;

public class DbHelper {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mariadb://localhost:3307";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Turkey#786";
	
	private void createDB() {
		
	}

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//STEP 4: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();

			//    String sql = "CREATE DATABASE STUDENTS2";
			//    stmt.executeUpdate(sql);
			//    System.out.println("Database created successfully...");

			String sqlTable = "CREATE TABLE Student " +
					"(id INTEGER not NULL, " +
					" nuid VARCHAR(255), " + 
					" firstName VARCHAR(255), " + 
					" lastName VARCHAR(255), " + 
					" emailId VARCHAR(255), " + 
					" gender VARCHAR(255), " + 
					" phoneNumber VARCHAR(255), " + 
					" startTerm VARCHAR(255), " + 
					" enrollmentstatus VARCHAR(255), " + 
					" major VARCHAR(255), " + 
					" degree VARCHAR(255), " + 
					" campus VARCHAR(255), " + 
					" citizenshipStatus VARCHAR(255), " + 
					" PRIMARY KEY ( id ))"; 

			// stmt.executeUpdate(sqlTable);
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
		}//end try
		System.out.println("Goodbye!");
	}//end main
}//end JDBCExample

