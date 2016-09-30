package com.psl.flashnotes.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.ILoginDao;
import com.psl.flashnotes.bean.LogIn;

@Repository
public class LoginDao implements ILoginDao {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public LogIn getLogin(String userName) {
		LogIn l1;
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql="from LogIn l where l.userName=:userName";
		Query query=session.createQuery(sql);
		query.setParameter("userName", userName);
		l1 = (LogIn)query.uniqueResult();
		//l1 = (LogIn) session.get(LogIn.class, userId);
		System.out.println(l1);
		tx.commit();
		return l1;

	}
public void addLoginDetails(String username, String newPassword) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		LogIn login=new LogIn();
		login.setUserName(username);
		login.setPassword(newPassword);
		session.save(login);
		tx.commit();
	}

}
