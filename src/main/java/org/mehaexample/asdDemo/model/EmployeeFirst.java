package org.mehaexample.asdDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Access(value=AccessType.FIELD)
public class EmployeeFirst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private int salary;

	@Override
	public String toString() {
		return "Id= " + id + ", Name= " + name + ", Salary= " + salary + "}";
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


}