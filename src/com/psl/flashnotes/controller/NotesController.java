package com.psl.flashnotes.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.psl.flashnotes.bean.Comment;
import com.psl.flashnotes.bean.Course;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.service.CommentService;
import com.psl.flashnotes.service.CourseService;
import com.psl.flashnotes.service.NotesService;
import com.psl.flashnotes.service.UserService;

@Controller
public class NotesController {
	@Autowired
	private NotesService noteservice;
	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/addNote/{courseId}", method = RequestMethod.POST)
	public ModelAndView addNotes(@PathVariable int courseId,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Gson gson = new Gson();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Notes notes = new Notes();
		notes.setNoteHeading(request.getParameter("noteHeading"));
		notes.setContentType(true);
		notes.setLikes(0);
		notes.setCategory(request.getParameter("noteCategory"));
		notes.setNoteBody(request.getParameter("noteBody"));

		Course course = courseService.getCourseById(courseId);
		notes.setCourse(course);

		session = request.getSession(false);
		int userId = (Integer) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		System.out.println(user);
		notes.setUser(user);

		mav.addObject("notes", gson.toJson(noteservice.addNotes(notes)));
		mav.setViewName("course");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
	}
	
	@RequestMapping(value = "/addNote1/{courseId}", method = RequestMethod.POST)
	public @ResponseBody String addNotes1(@RequestParam("noteHeading")String noteHeading,
									@RequestParam("noteCategory")String noteCategory,
									@RequestParam("noteBody") String noteBody,
									@PathVariable int courseId,
									HttpServletRequest request) {
		
		Gson gson = new Gson();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Notes notes = new Notes();
		notes.setNoteHeading(noteHeading);
		notes.setContentType(true);
		notes.setLikes(0);
		notes.setCategory(noteCategory);
		notes.setNoteBody(noteBody);

		Course course = courseService.getCourseById(courseId);
		notes.setCourse(course);

		session = request.getSession(false);
		int userId = (Integer) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		System.out.println(user);
		notes.setUser(user);

	//	mav.addObject("notes", gson.toJson(noteservice.addNotes(notes)));
		//mav.setViewName("course");
		String json=gson.toJson(noteservice.addNotes(notes));
		return json;
		}
		else{
//			mav.addObject("answer","Login first");
//			mav.setViewName("login");
			return "Please Login first";
			}
	}
	

	@RequestMapping("/getAllNotes/{courseId}")
	public ModelAndView getAllNotes(@PathVariable int courseId, HttpServletRequest request) {
		System.out.println("In Notes Controller");
		ModelAndView mav = new ModelAndView();
		Gson gson = new Gson();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		List<Notes> noteList = noteservice.getAllNotes(courseId);
		Collections.sort(noteList, new Comparator<Notes>() {
			@Override
			public int compare(Notes arg0, Notes arg1) {
				return arg1.getNoOfViews() - arg0.getNoOfViews();
			}
		});
		mav.addObject("noteList",gson.toJson(noteList));
		mav.setViewName("allNotes");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}
	
	@RequestMapping("/getTop3Notes/{courseId}")
	public ModelAndView getTop3Notes(@PathVariable int courseId, HttpServletRequest request) {
			System.out.println("In Notes Controller");
			ModelAndView mav = new ModelAndView();
			Gson gson = new Gson();
			HttpSession session=request.getSession(false);
			if(session!=null && session.getAttribute("userId")!=null){
			List<Notes> noteList = noteservice.getTopNotes(courseId);
			mav.addObject("noteList",gson.toJson(noteList));
			mav.setViewName("course");
			return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}

	@RequestMapping(value = "getNotesById/{noteId}")
	public ModelAndView getNotesById(@PathVariable int noteId,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Gson gson = new Gson();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Notes note = noteservice.getNotesById(noteId);
		System.out.println(note);

		//to get notes according to category depending on Noteid category
		/*

		List<Notes>newlist=noteservice.getNoteByCategory(noteId);
		mav.addObject("getnotelist",newlist);
		*/
	
		mav.addObject("note", gson.toJson(note));
		List<Comment> commentList = commentService.getAllComments(noteId);
		mav.addObject("commentList",gson.toJson(commentList));
		mav.addObject("loggedInUser",Globals.userIdentity);
		
		mav.setViewName("note");
		return mav;
	}
	else{
		mav.addObject("answer","Login first");
		mav.setViewName("/login");
		return mav;
		}
	}

	@RequestMapping(value = "updateLikes/{noteId}")
	public ModelAndView updateLikes(@PathVariable int noteId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		noteservice.updateLikes(noteId);
		Notes note=noteservice.getNotesById(noteId);
		 mav.addObject("note", note);
		mav.setViewName("note");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}

	@RequestMapping(value = "/updateLikes1/{noteId}")
	public @ResponseBody String updateLikes1(@PathVariable int noteId,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			noteservice.updateLikes(noteId);
			Notes note=noteservice.getNotesById(noteId);
			Gson gson=new Gson();
			String data = gson.toJson(note);
			return data;
		}
		else{
			return "Please Login to Continue!";
		}
	}
	
	@RequestMapping(value = "/editNotes/{noteId}", method = RequestMethod.POST)
	public ModelAndView updateNotes(@PathVariable("noteId") int noteId,
			@RequestParam("noteBody") String body,HttpServletRequest request) {
		System.out.println("Inside edit Notes/ ID Func");
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		mav.addObject("updatedNote", noteservice.editNotes(noteId, body));
		mav.setViewName("allNotes");
		return mav;
	}
	else{
		mav.addObject("answer","Login first");
		mav.setViewName("login");
		return mav;
		}
	}
	
	@RequestMapping(value = "/editNotes1/{noteId}", method = RequestMethod.POST)
	public @ResponseBody String updateNotes1(
			@PathVariable("noteId") int noteId,
			@RequestParam("noteBody") String body, 
			HttpServletRequest request) {
		System.out.println("Inside edit Notes/ ID Func");
		//ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		//mav.addObject("updatedNote", noteservice.editNotes(noteId, body));
		//mav.setViewName("allNotes");
			Gson gson=new Gson();
			String json=gson.toJson( noteservice.editNotes(noteId, body));
			return json;
	}
	else{
//		mav.addObject("answer","Login first");
//		mav.setViewName("login");
		return "Please Login first";
		}
	}
	
	@RequestMapping(value="/getNotesByAuthor/{userId}")
	public ModelAndView getNotesByAuthor(@PathVariable int userId,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			List<Notes> notesList=noteservice.getNotesByAuthorId(userId);
			mav.addObject("noteslistOfAuthor", notesList);
			mav.setViewName("display");
			return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}

	@RequestMapping(value = "getNotesByName", method = RequestMethod.POST)// new Updated
	public ModelAndView getNotesByName(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		String notesName = request.getParameter("notesName");
		if(session!=null && session.getAttribute("userId")!=null){
		Notes note = noteservice.getNotesByName(notesName);
		mav.addObject("notes", note);
		mav.setViewName("display");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login1");
			return mav;
		}
	}
}
