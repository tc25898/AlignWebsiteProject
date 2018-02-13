package org.mehaexample.asdDemo.alignWebsite;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mehaexample.asdDemo.dao.StudentExperienceDao;
import org.mehaexample.asdDemo.dao.StudentPriorEducationDao;
import org.mehaexample.asdDemo.model.Experience;
import org.mehaexample.asdDemo.model.PriorEducation;

@Path("studentExperienceResource")
public class StudentExperienceResource {

	StudentExperienceDao studentExperienceDao = new StudentExperienceDao();

	@GET
	@Path("{nuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Experience> getExperience(@PathParam("nuid") String nuid) {
		System.out.println("Getting Prior Education Details for student with nuid: " + nuid);
		ArrayList<Experience> list = (ArrayList<Experience>) studentExperienceDao.getExperience(nuid);
		return list;
	}

	@POST
	@Path("{nuid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveExperienceForm(@PathParam("nuid") String nuid, Experience experience){
		studentExperienceDao.addExperience(nuid, experience); 
	} 
}
