package com.psl.flashnotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;
	
	@Type(type="text")
	private String comment;
	
	private Date dateCreated;
	private Date lastUpdated;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "noteId")
	private Notes notes;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + "]";
	}

}
