package com.psl.flashnotes.controller;

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
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.service.CommentService;
import com.psl.flashnotes.service.NotesService;
import com.psl.flashnotes.service.UserService;

@Controller
public class CommentController {
	@Autowired
	private NotesService notesService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
@RequestMapping(value = "/addComment/{noteId}", method = RequestMethod.POST)
	public ModelAndView addComment(@RequestParam("comment") String comment,@PathVariable int noteId,HttpServletRequest request)  {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Comment addComment = new Comment();
		addComment.setComment(comment);
		
		Notes notes=notesService.getNotesById(noteId);
		addComment.setNotes(notes);

		session = request.getSession(false);
		int userId = (Integer) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		addComment.setUser(user);
		
		Gson gson = new Gson();
		
		mav.addObject("comments", gson.toJson(commentService.addComment(addComment)));
		mav.setViewName("note");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login1");
			return mav;
			}

	}

@RequestMapping(value = "/addComment1/{noteId}", method = RequestMethod.POST)
public @ResponseBody String  addComment1(@RequestParam("comment") String comment,@PathVariable int noteId,HttpServletRequest request)  {
	System.out.println("");
	HttpSession session=request.getSession(false);
	if(session!=null && session.getAttribute("userId")!=null){
	Comment newComment = new Comment();
	newComment.setComment(comment);
	
	Notes notes=notesService.getNotesById(noteId);
	newComment.setNotes(notes);

	session = request.getSession(false);
	int userId = (Integer) session.getAttribute("userId");
	User user = userService.getUserById(userId);
	newComment.setUser(user);
	
	Gson gson = new Gson();
	String json=gson.toJson(commentService.addComment(newComment));
	//mav.addObject("comments", gson.toJson(commentService.addComment(addComment)));
	//mav.setViewName("note");
	return json;
	}
	else{
		//mav.addObject("answer","Login first");
	//	mav.setViewName("login1");
		return "please Login First !";
		}

}

	@RequestMapping(value = "/retriveComment/{commentId}")
	public ModelAndView retriveComment(@PathVariable int commentId,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Comment comment = commentService.retriveComment(commentId);
		Gson gson = new Gson();
		mav.addObject("comment", gson.toJson(comment));
		mav.setViewName("display");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login1");
			return mav;
			}
	}

	@RequestMapping(value = "/getAllComments/{noteId}")
	public ModelAndView getAllComments(@PathVariable int noteId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		List<Comment> commentList = commentService.getAllComments(noteId);
		Gson gson = new Gson();
		mav.addObject("commentList", gson.toJson(commentList));
		mav.setViewName("note");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
	}

}