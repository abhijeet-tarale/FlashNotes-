package com.psl.flashnotes.Idao;

import java.util.List;

import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.NotesViews;

public interface INotesDAO {
	public Notes addNotes(Notes notes);

	public List<Notes> getAllNotes(int courseId);

	public Notes getNotesById(int id);

	public Notes updateLikes(int noteId);

	
	public Notes editNotes(int noteId, String area);
	
	public Notes updateView(Notes note,NotesViews notesView);

	public List<Notes> getNotesByAuthorId(int userId);

	public List<Notes> getTopNotes(int courseId);
	public Notes getNotesByName(String notesName);


}
