package test;

import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.dao.UserDAO;


public class Test {

	@org.junit.Test
	public void testCreateDB(){
		User u1=new User();
		u1.setUserName("abhijeet_tarale");
		UserDAO udao=new UserDAO();
		udao.addUser(u1);
	}
}
