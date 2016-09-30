package com.psl.flashnotes.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.INotesDAO;
import com.psl.flashnotes.bean.AnswerLikes;
import com.psl.flashnotes.bean.CompositeId1;
import com.psl.flashnotes.bean.CompositeId2;
import com.psl.flashnotes.bean.Course;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.NotesViews;
import com.psl.flashnotes.bean.User;

@Repository
public class NotesDAO implements INotesDAO {

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public Notes addNotes(Notes notes) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(notes);
		tx.commit();
		return notes;

	}

	@Override
	public List<Notes> getAllNotes(int courseId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Notes n where n.course.courseId=:id");
		query.setParameter("id", courseId);
		List<Notes> notesList = query.list();
		tx.commit();
		return notesList;
	}

	@Override
	public Notes getNotesById(int noteId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Notes notes = (Notes) session.get(Notes.class, noteId);
		tx.commit();
		return notes;
	}

	@Override
	public Notes updateLikes(int noteId) {

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Notes note = (Notes) session.get(Notes.class, noteId);
		//System.out.println(note);
		int like = note.getLikes() + 1;
		
		String sql = "update Notes set likes=:like where noteId=:noteId";
		Query query = session.createQuery(sql);
		query.setParameter("like", like);
		query.setParameter("noteId",noteId);
		query.executeUpdate();
		
		String psql = "update NotesViews set noteLiked=:noteLiked where compositeId.noteId=:noteId and compositeId.userId=:userId";
		Query query1 = session.createQuery(psql);
		query1.setParameter("noteLiked",1);
		query1.setParameter("noteId",noteId);
		query1.setParameter("userId",Globals.userIdentity);
		query1.executeUpdate();
		
		note = (Notes) session.get(Notes.class, noteId);
		
		
		int totalLike = note.getLikes();
		if (totalLike % 20 == 0&& totalLike>0) {
			
			int view = note.getNoOfViews();
			
			
			double efflike = (double)totalLike/view;
			System.out.println(efflike);
			if((efflike)>0.5)
			{		
			User user = (User) session.get(User.class, note.getUser()
					.getUserId());
			int qp = user.getQualityPoint() + 1;
			String qpsql = "update User set qualityPoint= :qp where userId=:userId";
			query = session.createQuery(qpsql);
			query.setParameter("qp", qp);
			query.setParameter("userId",user.getUserId());//added
			query.executeUpdate();
			}
		}
		
		NotesViewsDAO ndao=new NotesViewsDAO();
		NotesViews n1 =ndao.retrieveUser(Globals.userIdentity, noteId);
		System.out.println(n1.getViews());
		NotesViews notesViews=new NotesViews();
		CompositeId1 compositeId1=new CompositeId1();
		compositeId1.setUserId(Globals.userIdentity);
		compositeId1.setNoteId(noteId);
		notesViews.setCompositeId(compositeId1);
		notesViews.setViews(n1.getViews());
		notesViews.setNoteLiked(1);
		session.merge(notesViews);
		tx.commit();
		return note;
	}
	


	@Override
	public Notes editNotes(int noteId, String area) {

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Notes note = (Notes) session.get(Notes.class, noteId);
		note.setLastUpdated(new Date());
		note.setNoteBody(area);
		session.save(note);
		tx.commit();

		return note;
	}
	
	@Override
	public Notes updateView(Notes note,NotesViews noteViews1) {
		
	
		Session session = sf.getCurrentSession();
		session.getTransaction().begin();
		String sql = "update Notes set noOfViews=:views where noteId=:id";
		Query query = session.createQuery(sql);
		query.setParameter("views",note.getNoOfViews());
		query.setParameter("id", note.getNoteId());
		query.executeUpdate();
		session.merge(noteViews1);
		session.getTransaction().commit();
		
		return note;
		
	}

	@Override
	public Notes getNotesByName(String notesName) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Notes n where n.noteHeading=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", notesName);
		Notes note = (Notes) query.uniqueResult();
		tx.commit();
		return note;
	}
	

	@Override
	public List<Notes> getNotesByAuthorId(int userId) {
		Session session = sf.getCurrentSession();
		session.getTransaction().begin();
		
		String sql = "from Notes n where n.user.userId=:id";
		Query query = session.createQuery(sql);
		query.setParameter("id", userId);
		List<Notes>noteListOfAuthor=query.list();
		session.getTransaction().commit();
		return noteListOfAuthor;
	}

	@Override
	public List<Notes> getTopNotes(int courseId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Notes n where n.course.courseId=:id");
		query.setParameter("id", courseId);
		List<Notes> notesList = query.list();
		List<Notes> viewdList = new ArrayList<Notes>();
 		List<Notes> unviewed=new ArrayList<Notes>();
 		
 		for(Notes note:notesList)
 		{
 			if(note.getNoOfViews()>0)
 				viewdList.add(note);
 			else
 				unviewed.add(note);
 		}
 		
		Collections.sort(viewdList, new Comparator<Notes>() {

			@Override
			public int compare(Notes n1, Notes n2) {
				
				double eff2=(double)(n2.getLikes()/n2.getNoOfViews());
				double eff1=(double)(n1.getLikes()/n1.getNoOfViews());
				if((double)n2.getLikes()/n2.getNoOfViews()>(double)n1.getLikes()/n1.getNoOfViews()){
					return 1;
				}else if((double)n2.getLikes()/n2.getNoOfViews()<(double)n1.getLikes()/n1.getNoOfViews()){
					return -1;
				}
				return 0;
			}
		});
		tx.commit();
		viewdList.addAll(unviewed);
		return viewdList; // Send All  Notes
	}
}
