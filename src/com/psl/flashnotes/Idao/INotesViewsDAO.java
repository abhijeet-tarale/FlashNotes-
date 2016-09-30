package com.psl.flashnotes.Idao;


import com.psl.flashnotes.bean.NotesViews;

public interface INotesViewsDAO {
	public NotesViews retrieveUser(int userId,int noteId);
	//public void updateView(int userId);

}
