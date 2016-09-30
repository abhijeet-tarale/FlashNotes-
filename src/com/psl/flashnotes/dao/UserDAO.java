package com.psl.flashnotes.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.IUserDAO;
import com.psl.flashnotes.bean.User;

@Repository
public class UserDAO implements IUserDAO {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void addUser(User u1) {

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(u1);
		tx.commit();
	}

	public User getdet() {
		// TODO Auto-generated method stub
		User u1;
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		u1 = (User) session.get(User.class, 1);
		System.out.println(u1);
		tx.commit();
		return u1;
	}

	public List<User> getTopAnswrers() {
		// TODO Auto-generated method stub
		List<User> topMembers;
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from " + User.class.getName());
		topMembers = query.list();
		Collections.sort(topMembers, new Comparator<User>() {

			@Override
			public int compare(User u1, User u2) {
				return u2.getQualityPoint() - u1.getQualityPoint();
			}

		});
		tx.commit();
		return topMembers;
	}

	@Override
	public User getUsersById(int userId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, userId);
		tx.commit();
		return user;
	}

}
