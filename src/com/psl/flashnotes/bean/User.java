package com.psl.flashnotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int userId;

	private String userName;
	private int qualityPoint;
	private int giftCount;

/*	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
	private List<Notes> noteList;*/

	public User() {

	}

	public User(int userId, String userName, int qualityPoint, int creditPoint) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.qualityPoint = qualityPoint;
		this.giftCount = creditPoint;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getQualityPoint() {
		return qualityPoint;
	}

	public void setQualityPoint(int qualityPoint) {
		this.qualityPoint = qualityPoint;
	}

	public int getCreditPoint() {
		return giftCount;
	}

	public void setCreditPoint(int creditPoint) {
		this.giftCount = creditPoint;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", qualityPoint=" + qualityPoint + ", creditPoint="
				+ giftCount + "]";
	}

}
