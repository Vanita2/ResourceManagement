package com.yash.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeWorkExperience")
public class WorkExperience implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workExperienceId;

	private String previousCompany;

	private String startDate;

	private String endDate;

	private String designation;

	public WorkExperience() {
		System.out.println("WorkExperience called...");
	}

	public WorkExperience(int workExperienceId, String previousCompany, String startDate, String endDate,
			String designation) {
		super();
		System.out.println("work parameterized constructor called...");
		this.workExperienceId = workExperienceId;
		this.previousCompany = previousCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		this.designation = designation;
	}

	public int getWorkExperienceId() {
		return workExperienceId;
	}

	public void setWorkExperienceId(int workExperienceId) {
		this.workExperienceId = workExperienceId;
	}

	public String getPreviousCompany() {
		return previousCompany;
	}

	public void setPreviousCompany(String previousCompany) {
		this.previousCompany = previousCompany;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "WorkExperience [workExperienceId=" + workExperienceId + ", previousCompany=" + previousCompany
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", designation=" + designation + "]";
	}

}
