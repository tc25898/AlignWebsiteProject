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
import javax.ws.rs.core.MediaType;

import org.mehaexample.asdDemo.dao.StudentDaoHibernate;
import org.mehaexample.asdDemo.dao.StudentDaoJdbc;
import org.mehaexample.asdDemo.model.Student;

@Path("studentresource")
public class StudentResource {
	

	StudentDaoHibernate studentDaoHibernate = new StudentDaoHibernate();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		System.out.println("Getting all students");
		ArrayList<Student> list = (ArrayList<Student>) studentDaoHibernate.getAllStudents();

		return list;
	}

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

		boolean exists = studentDaoHibernate.ifNuidExists(student.getNuid());
		if(exists == false){			
			studentDaoHibernate.addStudentRecord(student);	
		}else{
			System.out.println("The entered NUID exists already");
		}
	} 
	
	@PUT
	@Path("/{nuid}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void updateStudentRecord(@PathParam("nuid") String nuid , Student student) {
		System.out.println("update record nuid=" + nuid);
		studentDaoHibernate.updateStudentRecordDao(nuid, student);
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
