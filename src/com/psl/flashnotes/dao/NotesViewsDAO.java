package com.psl.flashnotes.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.INotesViewsDAO;
import com.psl.flashnotes.bean.NotesViews;

@Repository
public class NotesViewsDAO implements INotesViewsDAO{
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	@Override
	public NotesViews retrieveUser(int userId,int noteId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql = "from NotesViews n where n.compositeId.userId=:id and n.compositeId.noteId=:nid";
		Query query = session.createQuery(sql);
		
		query.setParameter("id",userId);
		query.setParameter("nid",noteId);
		NotesViews n=(NotesViews)query.uniqueResult();
		System.out.println("NoteView Object to be Null:" + n );
		tx.commit();
		return n;
	}

	/*@Override
	public void updateView(int userId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql = "from NotesViews n where n.compositeId.userId=:id";
		Query query = session.createQuery(sql);
		
		query.setParameter("id",userId);
		NotesViews n=(NotesViews)query.uniqueResult();
		tx.commit();
		
	}*/
	

}
