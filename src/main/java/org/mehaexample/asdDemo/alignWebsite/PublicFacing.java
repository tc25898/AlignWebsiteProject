package org.mehaexample.asdDemo.alignWebsite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mehaexample.asdDemo.dao.StudentDao;
import org.mehaexample.asdDemo.model.Student;

@Path("public")
public class PublicFacing {

	// student end points
	StudentDao studentDao = new StudentDao();
	
	@GET
	@Path("search/{degree}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> searchSimilarStudents(@PathParam("degree") String degree){
		System.out.println("getting search results for degree = " + degree);
		ArrayList<Student> studentRecords = (ArrayList<Student>) studentDao.searchSimilarStudents(degree);
		return studentRecords; 
	}
	
	@GET
	@Path("student/{nuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentProfile(@PathParam("nuid") String nuid){
		System.out.println("getting student profile for nuid = " + nuid);
		Student studentRecord = studentDao.getStudentRecord(nuid);
		return studentRecord; 
	}
	
}
