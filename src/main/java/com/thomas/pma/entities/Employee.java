package com.thomas.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thomas.pma.validators.UniqueValue;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_generator")
	@SequenceGenerator(name="employee_generator", sequenceName="employee_seq", allocationSize= 10)
	private long employeeId;

	//ValidationRule
	//@NotNull
	@Size(min = 2, max = 50)
	private String firstname;
	
	//@NotNull
	@Size(min = 1, max = 50)
	private String lastname;
	
	//@NotNull
	@Email
	@UniqueValue
	private String email;
	
	//FetchType: EAGER - loads all child classes associated with the parent class. Can slow down the application. LAZY: loads only the parent class.
	//CascadeType: DETACH, MERGE, REMOVE, REFRESH, PERSIST or ALL of them - do the same action to the child class which had done to the parents class.
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="employee_id"),
	inverseJoinColumns=@JoinColumn(name="project_id")
	)	
	
	//Needs to be added to avoid stack overflow by using findAll method with REST Employee Controller
	@JsonIgnore
	private List<Project> projects;
	
	public Employee() {
		
	}
		
	public Employee(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	  
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	

	
	
}
