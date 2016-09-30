package com.psl.flashnotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Notes {

	@Id
	@GeneratedValue
	private int noteId;

	private String noteHeading;
	@Type(type="text")
	private String noteBody;
	private boolean contentType;
	private int likes;
	private String category;
	private int noOfViews;
	private Date dateCreated;
	private Date lastUpdated;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public Notes() {

	}

	public Notes(int noteId, String noteHeading, String noteBody,
			boolean contentType, int likes, Course course, User user) {
		super();
		this.noteId = noteId;
		this.noteHeading = noteHeading;
		this.noteBody = noteBody;
		this.contentType = contentType;
		this.likes = likes;
		this.course = course;
		this.user = user;
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

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteHeading() {
		return noteHeading;
	}

	public void setNoteHeading(String noteHeading) {
		this.noteHeading = noteHeading;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
	}

	public boolean isContentType() {
		return contentType;
	}

	public void setContentType(boolean contentType) {
		this.contentType = contentType;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notes [noteId=" + noteId + ", noteHeading=" + noteHeading
				+ ", noteBody=" + noteBody + ", contentType=" + contentType
				+ ", likes=" + likes + ", category=" + category
				+ ", noOfViews=" + noOfViews + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + "]";
	}

	

}
