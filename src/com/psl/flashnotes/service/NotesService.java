package com.psl.flashnotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.Idao.INotesDAO;
import com.psl.flashnotes.bean.CompositeId1;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.NotesViews;
import com.psl.flashnotes.dao.NotesViewsDAO;

@Service
public class NotesService {

	@Autowired
	private INotesDAO notesDAO;

	@Autowired
	private NotesViewsDAO notesViewsDAO;

	public Notes addNotes(Notes notes) {
		notes.setDateCreated(new Date());
		notes.setLastUpdated(new Date());
		return notesDAO.addNotes(notes);
	}

	public List<Notes> getAllNotes(int courseId){
		return notesDAO.getAllNotes(courseId);
	}
	
	public List<Notes> getTopNotes(int courseId){
		return notesDAO.getTopNotes(courseId);
	}
public Notes getNotesByName(String notesName) {

		return notesDAO.getNotesByName(notesName);
	}

	public Notes getNotesById(int noteId) {
		NotesViews notesViews = notesViewsDAO.retrieveUser(
				Globals.userIdentity, noteId);

		Notes note = notesDAO.getNotesById(noteId);
		NotesViews notesViews1 = notesViews;
		CompositeId1 compositeId1 = new CompositeId1();

		if (notesViews == null) {
			notesViews1 = new NotesViews();
			note.setNoOfViews(note.getNoOfViews() + 1);

			compositeId1.setUserId(Globals.userIdentity);
			compositeId1.setNoteId(noteId);
			notesViews1.setCompositeId(compositeId1);
			notesViews1.setViews(notesViews1.getViews() + 1);
			
			notesViews1.setNoteLiked(notesViews1.isNoteLiked());
			System.out.println("in if");

		} else {
			notesViews1.setCompositeId(notesViews1.getCompositeId());
			notesViews1.setViews(notesViews1.getViews() + 1);
			
			notesViews1.setNoteLiked(notesViews1.isNoteLiked());

		}

		notesDAO.updateView(note, notesViews1);
		return note;
	}

	public void updateLikes(int noteId) {

		NotesViews notesViews = notesViewsDAO.retrieveUser(
				Globals.userIdentity, noteId);
		if (notesViews.isNoteLiked()==0) {
			System.out.println("INSIDE IF");
			notesDAO.updateLikes(noteId);
		} else {
			System.out.println("Already Liked this Answer");
		}

	}
	public Notes editNotes(int noteId, String area) {

		return notesDAO.editNotes(noteId, area);

	}

	public List<Notes> getNotesByAuthorId(int userId) {
		
		return notesDAO.getNotesByAuthorId(userId);
	}

}
