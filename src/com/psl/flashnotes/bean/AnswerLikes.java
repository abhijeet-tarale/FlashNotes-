package com.psl.flashnotes.bean;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class AnswerLikes {
	
	@EmbeddedId
	private CompositeId2 compositeId;
	
	private boolean answerLiked;
	private Date dateCreated;
	private Date dateUpdated;
	

	public boolean isAnswerLiked() {
		return answerLiked;
	}

	public void setAnswerLiked(boolean answerLiked) {
		this.answerLiked = answerLiked;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Date date) {
		this.dateUpdated = date;
	}

	public CompositeId2 getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(CompositeId2 compositeId) {
		this.compositeId = compositeId;
	}

	

}
