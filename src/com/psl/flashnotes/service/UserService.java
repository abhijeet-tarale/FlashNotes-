package com.psl.flashnotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.Idao.IUserDAO;
import com.psl.flashnotes.bean.User;

@Service
public class UserService {
	@Autowired 
	private IUserDAO userDAO;
	public User getDetails()
	{
		 
		return userDAO.getdet();
	}
	
	public List<User> getTopAnswerers()
	{
		 
		return userDAO.getTopAnswrers();
	}
	
	public User getUserById( int userId) {
		
		return userDAO.getUsersById(userId);
	}
	

}
