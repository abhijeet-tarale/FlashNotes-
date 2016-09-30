package com.psl.flashnotes.Idao;

import java.util.List;

import com.psl.flashnotes.bean.Comment;

public interface ICommentDAO {
	public Comment addComment(Comment comment);

	public Comment retriveComment(int commentId);

	public List<Comment> getAllComment(int noteId);

}
