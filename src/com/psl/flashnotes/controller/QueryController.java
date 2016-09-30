package com.psl.flashnotes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.Queries;
import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.service.NotesService;
import com.psl.flashnotes.service.QueryService;
import com.psl.flashnotes.service.UserService;

@Controller
public class QueryController {
	@Autowired
	private UserService userService;
	@Autowired
	private NotesService noteService;
	@Autowired
	private QueryService queryService;

	@RequestMapping(value = "/addQuery/{noteId}", method = RequestMethod.POST)
	public ModelAndView addQuery(@PathVariable int noteId,
			HttpServletRequest request) {
		System.out.println("In query Controller");
		System.out.println("Note Id " +noteId );
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		String question = request.getParameter("question");

		System.out.println(request.getAttribute("q"));
		
		System.out.println(noteId);

		Queries q = new Queries();
		q.setQuestion(question);

		Notes note = noteService.getNotesById(noteId);
		System.out.println(note);
		q.setNote(note);

		
		session = request.getSession(false);
		int userId = (Integer) Globals.userIdentity;
		User user = userService.getUserById(userId);
		System.out.println(user);
		q.setUser(user);

		// q.setUser(user); user to be identified by session
		
		
		mav.addObject("Query",queryService.addQuery(q) );
		
		mav.setViewName("queries");
		// Once query is added , notes page is to be refreshed and added query
		// should be displayed
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}


	}


	@RequestMapping(value = "/addQuery1/{noteId}", method = RequestMethod.POST)
	public @ResponseBody String addQuery1(@RequestParam("question") String question,@PathVariable int noteId,
			HttpServletRequest request) {
		System.out.println("In query Controller");
		System.out.println("Note Id " +noteId );
	//	ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			//String question = request.getParameter("question");
	
			
			System.out.println(noteId);
	
			Queries q = new Queries();
			q.setQuestion(question);
	
			Notes note = noteService.getNotesById(noteId);
			System.out.println(note);
			q.setNote(note);
	
			
			session = request.getSession(false);
			int userId = (Integer) Globals.userIdentity;
			User user = userService.getUserById(userId);
			System.out.println(user);
			q.setUser(user);
	
			// q.setUser(user); user to be identified by session
			
			
		//	mav.addObject("Query",queryService.addQuery(q) );
			
		//	mav.setViewName("queries");
			// Once query is added , notes page is to be refreshed and added query
			// should be displayed
			Gson gson = new Gson();
			String json= gson.toJson(queryService.addQuery(q));
			System.out.println("Before Return : " + json);
			return json;
		}
		else{
			return "Please Login first";
		}
	}
	
	@RequestMapping("/getAllQueries/{noteId}")
	public ModelAndView getAllNotes(@PathVariable int noteId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Gson gson = new Gson();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		List<Queries> queryList = queryService.getAllQueries(noteId);
		mav.addObject("queryList",gson.toJson(queryList));
		Notes note=noteService.getNotesById(noteId);
		mav.addObject("note",gson.toJson(note));
		mav.setViewName("queries");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
	}

	@RequestMapping(value = "getQueriesById/{queryId}")
	public ModelAndView getCourseById(@PathVariable int queryId,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Gson gson = new Gson();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Queries query = queryService.getQueriesById(queryId);
		System.out.println(query);
		mav.addObject("query", gson.toJson(query));
		mav.setViewName("display");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
	}

}
