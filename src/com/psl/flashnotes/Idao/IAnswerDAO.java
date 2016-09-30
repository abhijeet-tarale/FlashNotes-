package com.psl.flashnotes.Idao;

import java.util.List;

import com.psl.flashnotes.bean.Answer;

public interface IAnswerDAO {
	public Answer addAnswer(Answer answer);

	public List<Answer> getAllAnswer();

	public Answer getAnswerById(int answerId);

	public Answer updateLikes(int answerId);

	public List<Answer> getAnswerByAuthorId(int userId);

	public List<Answer> getAnswer(int answerId);
}
