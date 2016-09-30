package com.psl.flashnotes.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeId1 implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "noteId")
   private int noteId;

   @Column(name = "userId")
   private int userId;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

 
}