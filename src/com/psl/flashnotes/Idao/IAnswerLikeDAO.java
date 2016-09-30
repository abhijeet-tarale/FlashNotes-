package com.psl.flashnotes.Idao;

import com.psl.flashnotes.bean.AnswerLikes;
import com.psl.flashnotes.bean.User;

public interface IAnswerLikeDAO {
	public AnswerLikes retrieveUser(int userId,int answerId);

}
