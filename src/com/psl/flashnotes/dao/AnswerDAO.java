package com.psl.flashnotes.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.IAnswerDAO;
import com.psl.flashnotes.bean.Answer;
import com.psl.flashnotes.bean.AnswerLikes;
import com.psl.flashnotes.bean.CompositeId2;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.User;

@Repository
public class AnswerDAO implements IAnswerDAO {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	@Override
	public List<Answer> getAnswer(int queryId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql="from Answer a where a.query.queryId=:id";
		Query query=session.createQuery(sql);
		query.setParameter("id", queryId);
		List<Answer> answerList=query.list();
	
		tx.commit();
		return answerList;
	}
	


	@Override
	public Answer addAnswer(Answer answer) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(answer);
		tx.commit();
		return answer;
	}

	@Override
	public List<Answer> getAllAnswer() {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from " + Answer.class.getName());
		List<Answer> answerList = query.list();
		tx.commit();
		return answerList;
	}

	@Override
	public Answer getAnswerById(int answerId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Answer answer = (Answer) session.get(Answer.class, answerId);
		tx.commit();
		return answer;
	}

	@Override
	public Answer updateLikes(int answerId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Answer answer = (Answer) session.get(Answer.class, answerId);
		System.out.println(answer);
		int like = answer.getLikes() + 1; 
		String sql = "update Answer set likes=:like where answerId=:answerId";//added
		Query query = session.createQuery(sql);
		query.setParameter("like", like);
	query.setParameter("answerId",answerId);//added
		query.executeUpdate();
		answer = (Answer) session.get(Answer.class, answerId);
		int totalLikes = answer.getLikes();
		if (totalLikes % 20 == 0) {
			User user = (User) session.get(User.class, answer.getUser()
					.getUserId());
			int qp = user.getQualityPoint() + 1; 
			String qpsql = "update User set qualityPoint= :qp where userId=:userId";
			query = session.createQuery(qpsql);
			query.setParameter("qp", qp);
			query.setParameter("userId",user.getUserId());
			query.executeUpdate();
			
			
		}
		//to update AnswerLikes table
		
		
		AnswerLikes answerLikes=new AnswerLikes();
		CompositeId2 compositeId2=new CompositeId2();
		compositeId2.setAnswerId(answerId);
		compositeId2.setUserId(Globals.userIdentity);
		answerLikes.setCompositeId(compositeId2);
		answerLikes.setAnswerLiked(true);
		answerLikes.setDateCreated(new Date());
		answerLikes.setDateUpdated(new Date());
		session.save(answerLikes);
		tx.commit();
		return answer;
	}

	@Override
	public List<Answer> getAnswerByAuthorId(int userId) {
		Session session = sf.getCurrentSession();
		session.getTransaction().begin();
		String sql = "select * from Answer a where a.user.userId=:id";
		Query query = session.createQuery(sql);
		query.setParameter("id", userId);
		List<Answer>answerListOfAuthor=query.list();
		session.getTransaction().commit();
		return answerListOfAuthor;
	}

	
}
