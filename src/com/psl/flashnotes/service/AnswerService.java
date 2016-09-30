package com.psl.flashnotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.Idao.IAnswerDAO;
import com.psl.flashnotes.bean.Answer;
import com.psl.flashnotes.bean.AnswerLikes;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.dao.AnswerLikeDAO;

@Service
public class AnswerService {
	@Autowired
	private IAnswerDAO answerDAO;
	
	@Autowired
	private AnswerLikeDAO answerLikeDAO;

	public Answer addAnswer(Answer answer) {
		answer.setDateCreated(new Date());
		answer.setLastUpdated(new Date());
		return answerDAO.addAnswer(answer);
	}

	public List<Answer> getAllAnswer() {
		return answerDAO.getAllAnswer();
	}

	public Answer getAnswerById(int answerId) {

		return answerDAO.getAnswerById(answerId);
	}

	public Answer updateLikes(int answerId) {
		Answer answer=null;
		AnswerLikes a=answerLikeDAO.retrieveUser(Globals.userIdentity,answerId);
		if(a==null)
			answer=answerDAO.updateLikes(answerId);
		else
			System.out.println("Already Liked this Answer");
		return answer;
	}
	
	public List<Answer> getAnswerByAuthorId(int userId){
		
		return answerDAO.getAnswerByAuthorId(userId);
	}

	public List<Answer> getAnswer(int answerId) {
		// TODO Auto-generated method stub
		return answerDAO.getAnswer(answerId);
	}

}
