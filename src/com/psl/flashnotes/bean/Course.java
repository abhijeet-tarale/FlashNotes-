package com.psl.flashnotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int courseId;

	private String courseName;
	private String courseContent;
	private String category;
	private int noOfViews;
	private Date dateCreated;
	private Date lastUpdated;

	public Course() {

	}

	public Course(int courseId, String courseName, String courseContent) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseContent = courseContent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNoOfViews() {
		return noOfViews;
	}

	public void setNoOfViews(int noOfViews) {
		this.noOfViews = noOfViews;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date date) {
		this.dateCreated = date;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ ", courseContent=" + courseContent + "]";
	}

}
