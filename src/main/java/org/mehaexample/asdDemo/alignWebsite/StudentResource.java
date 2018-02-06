package org.mehaexample.asdDemo.alignWebsite;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.mehaexample.asdDemo.dao.StudentDao;
import org.mehaexample.asdDemo.model.Student;

/**
 * Root resource (exposed at "myresource" path)
 */
// This is the controller layer
@Path("myresource")
public class StudentResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		System.out.println("Getting all students");
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> list = (ArrayList<Student>) studentDao.getAllStudents();

		return list;
	}

	@GET
	@Path("{nuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentRecord(@PathParam("nuid") String nuid){
		System.out.println("getting student for nuid = " + nuid);
		StudentDao studentDao = new StudentDao();
		Student studentRecord = studentDao.getStudentRecord(nuid);
		return studentRecord; 
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveStudentForm(Student student){
		StudentDao studentDao = new StudentDao();

		boolean exists = studentDao.ifNuidExists(student.getNUID());
		if(exists == false){
			int lastStudentId = studentDao.getLastStudentsId();
			student.setId(lastStudentId + 1);
			studentDao.addStudentRecord(student);	
		}else{
			System.out.println("The entered NUID exists already");
		}
	}

	@PUT
	@Path("{nuid}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void updateStudentRecord(@PathParam("nuid") String nuid , Student student) {
		StudentDao studentDao = new StudentDao();
		
		boolean exists = studentDao.ifNuidExists(student.getNUID());
		if(exists == true){
	        studentDao.updateStudentRecordDao(student);
		}else{
			System.out.println("Unable to update, Student doesn't exists");
		}
    }
	
	@DELETE
	@Path("{nuid}")
	@Produces({ MediaType.APPLICATION_JSON})
	public void deleteStudentByNUID(@PathParam("nuid") String nuid)
	{      
		System.out.println("delete called ");
		Student student = new Student();
		StudentDao studentDao = new StudentDao();

		System.out.println("nuid to be deleted is: " + nuid);
		boolean exists = studentDao.ifNuidExists(nuid);
		if(exists == true){
			studentDao.deleteStudentRecord(nuid);
		}else{
			System.out.println("This nuid doesn't exist");
		}
	} 
}
