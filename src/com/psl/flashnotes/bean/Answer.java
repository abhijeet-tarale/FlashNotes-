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
public class Answer {

	@Id
	@GeneratedValue
	private int answerId;
	
	@Type(type="text")
	private String answerContent;
	
	private int likes;

	private Date dateCreated;

	private Date lastUpdated;

	@ManyToOne
	@JoinColumn(name = "queryId")
	private Queries query;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public Answer() {

	}

	public Answer(int answerId, String answerContent, int likes, Queries query,
			User user) {
		super();
		this.answerId = answerId;
		this.answerContent = answerContent;
		this.likes = likes;
		this.query = query;
		this.user = user;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
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

	public void setLastUpdated() {
		this.lastUpdated = new Date();
	}

	public Queries getQuery() {
		return query;
	}

	public void setQuery(Queries query) {
		this.query = query;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerContent="
				+ answerContent + ", likes=" + likes + "]";
	}

}
