package com.psl.flashnotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.bean.Comment;
import com.psl.flashnotes.dao.CommentDAO;

@Service
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;

	public Comment addComment(Comment comment) {
		comment.setDateCreated(new Date());
		comment.setLastUpdated(new Date());
		return commentDAO.addComment(comment);
	}

	public Comment retriveComment(int commentId) {

		return commentDAO.retriveComment(commentId);
	}

	public List<Comment> getAllComments(int noteId) {

		return commentDAO.getAllComment(noteId);
	}

}
