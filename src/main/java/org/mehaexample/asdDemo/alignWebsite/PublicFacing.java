package org.mehaexample.asdDemo.alignWebsite;

import java.util.ArrayList;
import java.util.List;

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
	StudentDao studentDaoHibernate = new StudentDao();
	
	@GET
	@Path("search/{degree}/{major}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> searchSimilarStudents(@PathParam("degree") String degree, @PathParam("major") String major){
		System.out.println("getting search results for degree = " + degree + " major = " + major);
		ArrayList<Student> studentRecords = (ArrayList<Student>) studentDaoHibernate.searchSimilarStudents(degree, major);
		return studentRecords; 
	}
	
	@GET
	@Path("student/{nuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentProfile(@PathParam("nuid") String nuid){
		System.out.println("getting student profile for nuid = " + nuid);
		Student studentRecord = studentDaoHibernate.getStudentRecord(nuid);
		return studentRecord; 
	}
	
}
