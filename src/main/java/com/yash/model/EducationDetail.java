package com.yash.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeEducationDetail")
public class EducationDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationDetailId;

	private String qualification;

	private String startDate;

	private String endDate;

	private String collegeName;

	private int percentage;

	private String city;

	public EducationDetail() {
		System.out.println("educationDetail called....");
	}

	public EducationDetail(int educationDetailId, String qualification, String startDate, String endDate,
			String collegeName, int percentage, String city) {
		super();
		System.out.println("education parameterized constructor called...");
		this.educationDetailId = educationDetailId;
		this.qualification = qualification;
		this.startDate = startDate;
		this.endDate = endDate;
		this.collegeName = collegeName;
		this.percentage = percentage;
		this.city = city;
	}

	public int getEducationDetailId() {
		return educationDetailId;
	}

	public void setEducationDetailId(int educationDetailId) {
		this.educationDetailId = educationDetailId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "EducationDetail [educationDetailId=" + educationDetailId + ", qualification=" + qualification
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", collegeName=" + collegeName + ", percentage="
				+ percentage + ", city=" + city + "]";
	}

}
