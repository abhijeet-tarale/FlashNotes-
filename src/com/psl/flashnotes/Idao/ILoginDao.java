package com.psl.flashnotes.Idao;

import com.psl.flashnotes.bean.LogIn;

public interface ILoginDao {
	public LogIn getLogin(String userName);
}
