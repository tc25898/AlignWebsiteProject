package org.mehaexample.asdDemo.alignWebsite;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.mehaexample.asdDemo.dao.StudentDao;
import org.mehaexample.asdDemo.model.Student;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @POST
	@Consumes("application/x-www-form-urlencoded")
    public void saveStudentForm(MultivaluedMap<String, String> postData){
    	Student student = new Student();
    	
    	String nuid = postData.getFirst("NUID");
    	String firstName = postData.getFirst("firstName");
    	String lastName = postData.getFirst("lastName");
    	String emailId = postData.getFirst("emailId");
    	String gender = postData.getFirst("gender");
    	String phoneNumber = postData.getFirst("phoneNumber");
    	String address = postData.getFirst("address");
    	String expectedGraduation = postData.getFirst("expectedGraduation");
    	String startTerm = postData.getFirst("startTerm");
    	String enrollmentstatus = postData.getFirst("enrollmentstatus");
    	String major = postData.getFirst("major");
    	String degree = postData.getFirst("degree");
    	String campus = postData.getFirst("campus");
    	String citizenshipStatus = postData.getFirst("citizenshipStatus");
    		
    	student.setId(1);
    	student.setNUID(nuid);
    	student.setFirstName(firstName);
    	student.setLastName(lastName);
    	student.setEmailId(emailId);
    	student.setGender(gender);
    	student.setPhoneNumber(phoneNumber);
    	student.setAddress(address);
    	student.setExpectedGraduation(expectedGraduation);
    	student.setStartTerm(startTerm);
    	student.setEnrollmentstatus(enrollmentstatus);
    	student.setMajor(major);
    	student.setDegree(degree);
    	student.setCampus(campus);
    	student.setCitizenshipStatus(citizenshipStatus);
    	
    	StudentDao studentDao = new StudentDao();
    	int countStudents = studentDao.getStudentsCount();
    	student.setId(countStudents + 1);
    	studentDao.addStudentRecord(student);
    }
}
