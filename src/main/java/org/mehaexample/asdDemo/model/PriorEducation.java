package org.mehaexample.asdDemo.model;

public class PriorEducation {
	private int id;
	private String nuid;
	private String institutionName;
	private String degreeLevel;
	private String major;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	} 
	
	public String getNuid() {
		return nuid;
	}

	public void setNuid(String nuid) {
		this.nuid = nuid;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	public String getDegreeLevel() {
		return degreeLevel;
	}
	
	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
}
