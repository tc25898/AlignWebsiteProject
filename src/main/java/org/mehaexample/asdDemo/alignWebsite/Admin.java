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

@Path("admin")
public class Admin{
	
	// student details methods
	
	StudentDao studentDaoHibernate = new StudentDao();
	
	@GET
	@Path("search/{firstName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> searchStudent(@PathParam("firstName") String firstName){
		System.out.println("getting search results for firstName = " + firstName);
		ArrayList<Student> studentRecords = (ArrayList<Student>) studentDaoHibernate.searchStudentRecord(firstName);
		return studentRecords; 
	}
	
	@GET
	@Path("student/{nuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentProfile(@PathParam("nuid") String nuid){
		System.out.println("getting student for nuid = " + nuid);
		Student studentRecord = studentDaoHibernate.getStudentRecord(nuid);
		return studentRecord; 
	}
	
	
	// Data analytics methods
	
	@GET
	@Path("analytics/genderratio")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGenderRatio(){
		System.out.println("getting gender ratio");
		String ratio = "5:6";
		return ratio; 
	}
	
	@GET
	@Path("analytics/topbachelordegrees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getTopBachelorDegree(){
		System.out.println("getting top bachelor degrees");
		ArrayList<String> list = new ArrayList<String>();
		return list; 
	}
	
	@GET
	@Path("analytics/topemployers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getTopEmployers(){
		System.out.println("getting top employers");
		ArrayList<String> list = new ArrayList<String>();
		return list; 
	}
	
	@GET
	@Path("analytics/topelectives")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getTopElectives(){
		System.out.println("getting top electives");
		ArrayList<String> list = new ArrayList<String>();
		return list; 
	}
	
	@GET
	@Path("analytics/withworkexp")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsWorkExp(){
		System.out.println("getting total number of students with work experience");
		int total = 12;
		return total; 
	}
	
	@GET
	@Path("analytics/workinginfacebook")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsWorkingInFacebook(){
		System.out.println("getting total number of students working in facebook");
		int total = 13;
		return total; 
	}
	
	@GET
	@Path("analytics/workinginamazon")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsWorkingInAmazon(){
		System.out.println("getting total number of students working in amazon");
		int total = 14;
		return total; 
	}
	
	@GET
	@Path("analytics/workingingoogle")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsWorkingInGoogle(){
		System.out.println("getting total number of students working in google");
		int total = 4;
		return total; 
	}
	
	@GET
	@Path("analytics/workinginmicrosoft")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsWorkingInMicrosoft(){
		System.out.println("getting total number of students working in microsoft");
		int total = 5;
		return total; 
	}
	
	@GET
	@Path("analytics/withscholarship")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsWithScholarship(){
		System.out.println("getting total number of students with scholarship");
		int total = 23;
		return total; 
	}
	
	@GET
	@Path("analytics/alignseattle")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsAlignSeattle(){
		System.out.println("getting total number of ALIGN students in seattle");
		int total = 45;
		return total; 
	}
	
	@GET
	@Path("analytics/alignboston")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsAlignBoston(){
		System.out.println("getting total number of ALIGN students in boston");
		int total = 55;
		return total; 
	}
	
	@GET
	@Path("analytics/aligncharlotte")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsAlignCharlotte(){
		System.out.println("getting total number of ALIGN students in charlotte");
		int total = 15;
		return total; 
	}
	
	@GET
	@Path("analytics/alignsiliconvalley")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStudentsAlignSiliconValley(){
		System.out.println("getting total number of ALIGN students in silicon valley");
		int total = 5;
		return total; 
	}
	
}
