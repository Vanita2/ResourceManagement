package com.yash.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	private String firstName;

	private String lastName;

	private int phoneNumber;

	private String username;

	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "Employee_Address", joinColumns = { @JoinColumn(name = "employeeId") }, inverseJoinColumns = {
			@JoinColumn(name = "addressId") })
	private List<Address> addresses;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "Employee_EducationDetail", joinColumns = {
			@JoinColumn(name = "employeeId") }, inverseJoinColumns = { @JoinColumn(name = "educationDetailId") })
	private List<EducationDetail> educationDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "Employee_WorkExperience", joinColumns = {
			@JoinColumn(name = "employeeId") }, inverseJoinColumns = { @JoinColumn(name = "workExperienceId") })
	private List<WorkExperience> workExperiences;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "Employee_Skill", joinColumns = { @JoinColumn(name = "employeeId") }, inverseJoinColumns = {
			@JoinColumn(name = "skillId") })
	private List<Skill> skills;

	/* @org.hibernate.annotations.Type(type = "yes_no") */
	private boolean deleted;

	public Employee() {
		System.out.println("employee called...");
	}

	public Employee(int employeeId, String firstName, String lastName, int phoneNumber, String username,
			String password, List<Address> addresses, List<EducationDetail> educationDetails,
			List<WorkExperience> workExperiences, List<Skill> skills, boolean deleted) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.addresses = addresses;
		this.educationDetails = educationDetails;
		this.workExperiences = workExperiences;
		this.skills = skills;
		this.deleted = deleted;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<EducationDetail> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(List<EducationDetail> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public List<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password + ", addresses="
				+ addresses + ", educationDetails=" + educationDetails + ", workExperiences=" + workExperiences
				+ ", skills=" + skills + ", deleted=" + deleted + "]";
	}

}
