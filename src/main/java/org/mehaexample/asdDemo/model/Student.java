package org.mehaexample.asdDemo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int id;
	private String nuid;
	private String username;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int age;
	private String phoneNumber;
	private String address;
	private String emailId;
	private String campus;
	private String major;
	private String degree;
	private String entryTerm;

	private String expectedGraduation;
	private String enrollmentStatus; 
	private String citizenshipStatus;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCitizenshipStatus() {
		return citizenshipStatus;
	}

	public void setCitizenshipStatus(String citizenshipStatus) {
		this.citizenshipStatus = citizenshipStatus;
	}

	private String photo;
	
	public Student(){
		
	}
	
	public String getNuid() {
		return nuid;
	}

	public void setNuid(String nuid) {
		this.nuid = nuid;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEntryTerm() {
		return entryTerm;
	}

	public void setEntryTerm(String entryTerm) {
		this.entryTerm = entryTerm;
	}

	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNUID() {
		return nuid;
	}
	
	public void setNUID(String nUID) {
		nuid = nUID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getExpectedGraduation() {
		return expectedGraduation;
	}
	
	public void setExpectedGraduation(String expectedGraduation) {
		this.expectedGraduation = expectedGraduation;
	}
	
	public String getStartTerm() {
		return entryTerm;
	}
	
	public void setStartTerm(String startTerm) {
		this.entryTerm = startTerm;
	}
	
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getCampus() {
		return campus;
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
