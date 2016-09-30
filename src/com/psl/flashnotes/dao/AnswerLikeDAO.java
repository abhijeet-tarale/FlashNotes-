package com.psl.flashnotes.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.IAnswerLikeDAO;
import com.psl.flashnotes.bean.AnswerLikes;
@Repository
public class AnswerLikeDAO implements IAnswerLikeDAO{

	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	@Override
	public AnswerLikes retrieveUser(int userId,int answerId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql = "from AnswerLikes a where a.compositeId.userId=:id and a.compositeId.answerId=:id1";//added
		Query query = session.createQuery(sql);
		System.out.println("user Id"+userId);
		query.setParameter("id",userId);
		query.setParameter("id1",answerId);//added
		AnswerLikes a=(AnswerLikes)query.uniqueResult();
		tx.commit();
		
		return a;
	}

}
