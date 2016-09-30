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
public class Queries {
	@Id
	@GeneratedValue
	private int queryId;
	
	@Type(type="text")
	private String question;
	
	private Date dateCreated;
	private Date lastUpdated;

	@ManyToOne
	@JoinColumn(name = "noteId")
	private Notes note;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public Queries() {

	}

	public Queries(int queryId, String question, Notes note, User user) {
		super();
		this.queryId = queryId;
		this.question = question;
		this.note = note;
		this.user = user;
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public Notes getNote() {
		return note;
	}

	public void setNote(Notes note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Query [queryId=" + queryId + ", question=" + question + "]";
	}

}
