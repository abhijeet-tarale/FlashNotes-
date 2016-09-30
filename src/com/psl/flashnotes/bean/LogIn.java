package com.psl.flashnotes.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LogIn {

	@Id
	@GeneratedValue
	private int userId;
	@Column(unique=true)
	private String userName;
	private String password;

	public LogIn() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LogIn(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LogIn [userId=" + userId + ", password=" + password + "]";
	}

}
