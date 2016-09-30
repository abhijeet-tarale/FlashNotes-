package com.psl.flashnotes.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.ICommentDAO;
import com.psl.flashnotes.bean.Comment;

@Repository
public class CommentDAO implements ICommentDAO {

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public Comment addComment(Comment comment) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(comment);
		tx.commit();
		return comment;

	}

	@Override
	public Comment retriveComment(int commentId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Comment comment = (Comment) session.get(Comment.class, commentId);
		tx.commit();
		return comment;
	}

	@Override
	public List<Comment> getAllComment(int noteId) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql = "from Comment c where c.notes.noteId=:id";
		Query query = session.createQuery(sql);
		query.setParameter("id", noteId);
		List<Comment> commentList = (List<Comment>) query.list();
		tx.commit();
		return commentList;
	}

}
