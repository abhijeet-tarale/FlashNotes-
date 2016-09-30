package com.psl.flashnotes.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable

public class CompositeId2 implements Serializable {
	
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name = "answerId")
	    private int answerId;

	    @Column(name = "userId")
	    private int userId;

		public int getAnswerId() {
			return answerId;
		}

		public void setAnswerId(int answerId) {
			this.answerId = answerId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
	}



