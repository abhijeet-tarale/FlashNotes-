package com.psl.flashnotes.Idao;

import java.util.List;

import com.psl.flashnotes.bean.User;

public interface IUserDAO {
	public void addUser(User u1);

	public User getdet();

	public List<User> getTopAnswrers();

	public User getUsersById(int id);

}
