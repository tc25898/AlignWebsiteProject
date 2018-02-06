package org.mehaexample.asdDemo.alignWebsite;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;

import org.mehaexample.asdDemo.dao.StudentDao;
import org.mehaexample.asdDemo.model.Student;

@Path("deleteresource")
public class StudentDeleteResource {
	

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void deleteStudentByNUID(MultivaluedMap<String, String> postData)
	{      
		System.out.println("delete called ");
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
	
		String nuid = postData.getFirst("deleteId");
		System.out.println("nuid dellete" + nuid);
    	boolean exists = studentDao.ifNuidExists(nuid);
    	if(exists == true){
    		// passing the student nuid here , not the student itself
    		studentDao.deleteStudentRecord(nuid);
    	}
	}
}
