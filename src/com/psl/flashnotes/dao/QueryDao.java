package com.psl.flashnotes.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psl.flashnotes.Idao.IQueryDao;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.Queries;

@Repository
public class QueryDao implements IQueryDao {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public Queries addQuery(Queries query) {
		System.out.println("In query Dao!!!");
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(query);
		tx.commit();
		return query;
	}

	@Override
	public List<Queries> getAllQueries(int noteId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from " + Queries.class.getName()+" where noteId=:noteId");
		query.setParameter("noteId",noteId);
		List<Queries> queryList = query.list();
		tx.commit();
		return queryList;
	}

	@Override
	public Queries getQueryById(int queryId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Queries query = (Queries) session.get(Queries.class, queryId);
		tx.commit();
		return query;
	}

}
