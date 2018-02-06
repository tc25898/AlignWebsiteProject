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
	private Connection conn = null;
	private Statement stmt = null;
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://localhost/STUDENTS2";

	//Database credentials
	private final String USER = "root";
	private final String PASS = "Turkey#786";

	public StudentDao() {
		try{
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection successful");
			stmt = conn.createStatement();
		}catch(Exception ex){

		}
	}

	// Create a student record
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
		try{
			stmt.executeUpdate(sqlInsertRecord);

			System.out.println("Created table in given database...");
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// Read a student record for a given NUID
	public Student getStudentRecord(String nuid){
		Student student = new Student();
		if(nuid == null || nuid.isEmpty()){
			return null;
		}

		if(ifNuidExists(nuid)){
			try {
				ResultSet rs = stmt.executeQuery("select * from Student where nuid = '" + nuid + "' ");

				while(rs.next()){
					//Retrieve by column name
					student.setId(rs.getInt("id"));
					student.setNUID(rs.getString("nuid"));
					student.setFirstName(rs.getString("firstName"));
					student.setLastName(rs.getString("lastName"));
					student.setEmailId(rs.getString("emailId"));
					student.setGender(rs.getString("gender"));
					student.setPhoneNumber(rs.getString("phoneNumber"));
					student.setAddress(rs.getString("address"));
					student.setExpectedGraduation(rs.getString("expectedGraduation"));
					student.setStartTerm(rs.getString("startTerm"));
					student.setEnrollmentStatus(rs.getString("enrollmentStatus"));
					student.setMajor(rs.getString("major"));
					student.setDegree(rs.getString("degree"));
					student.setCampus(rs.getString("campus"));
				}
				rs.close();
			} 
			catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}

			return student;	
		}
		else{
			System.out.println("This nuid does'nt exists");
			return null;
		}
	}

	public boolean deleteStudentRecord(String nuid){		
		try{
			String sql = "DELETE FROM student " +
					"WHERE nuid = '" + nuid + "' ";
			System.out.println("delete sql: " + sql);
			stmt.executeUpdate(sql);

		}catch(Exception ex){

		}
		return false;
	}

	public boolean ifNuidExists(String nuid){
		try{
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
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		try{
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
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

		return list;
	}

	public void updateStudentRecordDao(Student student){
		try{
			System.out.println("Updatig Student Record.......");
			String sql = "UPDATE student " + 
					"SET " +
					"firstName = '" + student.getFirstName() + "'," +
					"lastName = '" + student.getLastName() + "' " +
					"WHERE nuid = '"+ student.getNuid() + "' ";
			int updates = stmt.executeUpdate(sql);
			System.out.println("update staement = " + sql +  " , " + updates);

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int getLastStudentsId() {		
		try{
			int lastRowId = -1;
			ResultSet rs = stmt.executeQuery("SELECT * from student ORDER BY ID DESC LIMIT 1");

			while(rs.next()){
				lastRowId = rs.getInt(1);	
			}
			System.out.println("Last row id: " + lastRowId);

			return lastRowId;
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
