package org.mehaexample.asdDemo.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.mehaexample.asdDemo.enums.DegreeCandidacy;

@XmlRootElement
public class PriorEducation {
	private int id;
	private String neuId;
	private String institutionId;
	private int majorId;
	private Date graduationDate;
	private String degreeLevel;
	private float gpa;
	private DegreeCandidacy degreeCandidacy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNeuId() {
		return neuId;
	}

	public void setNeuId(String neuId) {
		this.neuId = neuId;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getDegreeLevel() {
		return degreeLevel;
	}

	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public DegreeCandidacy getDegreeCandidacy() {
		return degreeCandidacy;
	}

	public void setDegreeCandidacy(DegreeCandidacy degreeCandidacy) {
		this.degreeCandidacy = degreeCandidacy;
	}

}
