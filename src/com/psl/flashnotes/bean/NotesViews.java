package com.psl.flashnotes.bean;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class NotesViews {
	
	@EmbeddedId
	private CompositeId1 compositeId;

	private int views;
	private int noteLiked;
	

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public CompositeId1 getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(CompositeId1 compositeId) {
		this.compositeId = compositeId;
	}

	public int isNoteLiked() {
		return noteLiked;
	}

	public void setNoteLiked(int noteLiked) {
		this.noteLiked = noteLiked;
	}

	@Override
	public String toString() {
		return "NotesViews [compositeId=" + compositeId + ", views=" + views
				+ ", noteLiked=" + noteLiked + "]";
	}
	
	
	
}
