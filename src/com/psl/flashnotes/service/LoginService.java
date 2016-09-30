package com.psl.flashnotes.service;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.bean.LogIn;
import com.psl.flashnotes.dao.LoginDao;

@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private SimpleMD5Example md5Example;

	public boolean isValid(String userName, String password) {
		String newPassword=null;
	
	newPassword=md5Example.getSecurePassword(password);
		/*System.out.println("user id"+ userId +"newpassword ="+newPassword);*/
		
		LogIn login = loginDao.getLogin(userName);
		if (login != null && login.getUserName().equals(userName) && login.getPassword().equals(newPassword))
			return true;
		return false;

	}
	public LogIn getLogin(String userName){
		return loginDao.getLogin(userName);
	}

	public void addLoginDetails(String username, String password) {
		
		String newPassword=md5Example.getSecurePassword(password);
		loginDao.addLoginDetails(username,newPassword);
	}
}
