package org.mehaexample.asdDemo.model;



import java.sql.Blob;
import javax.xml.bind.annotation.XmlRootElement;

import org.mehaexample.asdDemo.enums.Campus;
import org.mehaexample.asdDemo.enums.DegreeCandidacy;
import org.mehaexample.asdDemo.enums.EnrollmentStatus;
import org.mehaexample.asdDemo.enums.Gender;

@XmlRootElement
public class Student {
	private int id;
	private String neuId;
	private String email;
	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private boolean scholarship;
	private boolean f1Visa;
	private int age;
	private String phone;
	private String address;
	private String state;
	private String zip;
	private EnrollmentStatus enrollmentStatus;
	private Campus campus;
	private DegreeCandidacy degreeCandidacy;
	private String photo;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isScholarship() {
		return scholarship;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}

	public boolean isF1Visa() {
		return f1Visa;
	}

	public void setF1Visa(boolean f1Visa) {
		this.f1Visa = f1Visa;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public EnrollmentStatus getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public DegreeCandidacy getDegreeCandidacy() {
		return degreeCandidacy;
	}

	public void setDegreeCandidacy(DegreeCandidacy degreeCandidacy) {
		this.degreeCandidacy = degreeCandidacy;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
