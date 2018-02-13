package org.mehaexample.asdDemo.alignWebsite;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.mehaexample.asdDemo.dao.StudentDao;
import org.mehaexample.asdDemo.model.Student;

import utils.StudentDaoJdbc;

@Path("studentresource")
public class StudentResource {
	StudentDao studentDaoHibernate = new StudentDao();
	
	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		System.out.println("Getting all students");
		ArrayList<Student> list = (ArrayList<Student>) studentDaoHibernate.getAllStudents();
		
		return list;
	}
	
	// Template method for fetching a student record by nuid
	// http://localhost:8080/alignWebsite/webapi/studentresource?emailId=ashley.fields@husky.neu.edu
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentRecordByEmailId(@QueryParam("emailId") String emailId){
		System.out.println("get by email : " + emailId);
		return new Student(); 
	}

	// Template method for fetching a student record by email
	// http://localhost:8080/alignWebsite/webapi/studentresource/123
	@GET
	@Path("{nuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentRecord(@PathParam("nuid") String nuid){
		System.out.println("getting student for nuid = " + nuid);
		Student studentRecord = studentDaoHibernate.getStudentRecord(nuid);
		return studentRecord;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveStudentForm(Student student){
		System.out.println("saving student " + student.getFirstName() + ", " + student.getNuid());
		boolean exists = studentDaoHibernate.ifNuidExists(student.getNuid());
		System.out.println("student exists = " + exists);
		if(exists == false){			
			studentDaoHibernate.addStudentRecord(student);	
		}else{
			System.out.println("The entered NUID exists already");
		}
	}
	
	// Template method for updating a student record by nuid
	@PUT
	@Path("/{nuid}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void updateStudentRecord(@PathParam("nuid") String nuid , Student student) {
		System.out.println("update record nuid=" + nuid);
		studentDaoHibernate.updateStudentRecordDao(nuid, student);
    }

	// Template method for updating a student record by email
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void updateStudentRecordByEmail(@QueryParam("emailId") String emailId , Student student) {
		System.out.println("update record nuid=" + emailId);
		studentDaoHibernate.updateStudentRecordDaoByEmail(emailId, student);
    }
	
	// student opt-in/opt-out
	@PUT
	@Path("/opt-in/{nuid}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void updateStudentOptIn(@PathParam("nuid") String nuid , Student student) {
		System.out.println("update opt-in field for nuid=" + nuid);
    }	
	
	@DELETE
	@Path("{nuid}")
	@Produces({ MediaType.APPLICATION_JSON})
	public void deleteStudentByNUID(@PathParam("nuid") String nuid)
	{      
		System.out.println("delete called ");
		Student student = new Student();

		System.out.println("nuid to be deleted is: " + nuid);
		boolean exists = studentDaoHibernate.ifNuidExists(nuid);
		System.out.println("exists = " + exists);
		if(exists == true){
			studentDaoHibernate.deleteStudentRecord(nuid);
		}else{
			System.out.println("This nuid doesn't exist");
		}
	} 
}
