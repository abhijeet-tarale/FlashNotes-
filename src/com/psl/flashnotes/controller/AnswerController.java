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
import com.psl.flashnotes.bean.Answer;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.bean.Queries;
import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.service.AnswerService;
import com.psl.flashnotes.service.QueryService;
import com.psl.flashnotes.service.UserService;

@Controller
public class AnswerController {
	@Autowired
	private UserService userService;
	@Autowired
	private QueryService queryService;
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping(value = "/addAnswer/{queryId}", method = RequestMethod.GET)
	public ModelAndView addAnswer(@PathVariable int queryId, HttpServletRequest request) {

		System.out.println("Inside AnswerContr");
		
		ModelAndView mav = new ModelAndView("answersOnQuery");// EDIT THE PAGE ACCORDINGLY
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		
		String answerString = request.getParameter("answer");
		Answer answer = new Answer();
//		System.out.println(answerString);
		answer.setAnswerContent(answerString);

		Queries query = queryService.getQueriesById(queryId);
//		System.out.println(query);
		answer.setQuery(query);

		session = request.getSession(false);
		int userId = (Integer) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		System.out.println(user);

		answer.setUser(user);

		// q.setUser(user); user to be identified by session

		// Once query is added , notes page is to be refreshed and added query
		// should be displayed
		
		Gson gson=new Gson();
		mav.addObject("addAnswer",gson.toJson(answerService.addAnswer(answer)));
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}
	
	@RequestMapping(value = "/addAnswer1/{queryId}", method = RequestMethod.POST)
	public @ResponseBody String addAnswer1(@RequestParam("answer") String answer,@PathVariable int queryId, HttpServletRequest request) {

		System.out.println("Inside AnswerContr");
		
		//ModelAndView mav = new ModelAndView("answersOnQuery");// EDIT THE PAGE ACCORDINGLY
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		
		//String answerString = request.getParameter("answer");
		Answer newAnswer = new Answer();
		
		newAnswer.setAnswerContent(answer);

		Queries query = queryService.getQueriesById(queryId);
		System.out.println(query);
		newAnswer.setQuery(query);

		session = request.getSession(false);
		int userId = (Integer) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		System.out.println(user);

		newAnswer.setUser(user);

		// q.setUser(user); user to be identified by session

		// Once query is added , notes page is to be refreshed and added query
		// should be displayed
		
		Gson gson=new Gson();
	//	mav.addObject("addAnswer",gson.toJson(answerService.addAnswer(answer)));
		//return mav;
		String json=gson.toJson(answerService.addAnswer(newAnswer));
		return json;
		}
		else{
			//mav.addObject("answer","Login first");
			//mav.setViewName("login");
			return "please Login first";
		}
	}

	@RequestMapping("/getAllAnswers")
	public ModelAndView getAllNotes(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			
		List<Answer> answerList = answerService.getAllAnswer();
		
		
		//mav.addObject("answerList", answerList);
		Gson gson=new Gson();
		mav.addObject("addAnswer",gson.toJson(answerList));
		mav.setViewName("display");
		return mav;
	}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
		
	}

	@RequestMapping(value = "getAnswer/{queryId}")
	public ModelAndView getAnswer(@PathVariable int queryId,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		System.out.println(session);
		ModelAndView mav = new ModelAndView();
		if(session!=null){
			List<Answer> answerList = answerService.getAnswer(queryId);
			System.out.println(answerList);
			Queries query=queryService.getQueriesById(queryId);
			Gson gson=new Gson();
			mav.addObject("answerList",gson.toJson(answerList));
			mav.addObject("loggedInUser", Globals.userIdentity);
			mav.addObject("query",gson.toJson(query));
			//mav.addObject("answer", answer);
			mav.setViewName("answersOnQuery");
			return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}

	@RequestMapping(value = "/getAnswerById/{answerId}")
	public ModelAndView getCourseById(@PathVariable int answerId,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		System.out.println(session);
		ModelAndView mav = new ModelAndView();
		if(session!=null){
		
		Answer answer = answerService.getAnswerById(answerId);
		System.out.println(answer);
		Gson gson=new Gson();
		mav.addObject("answer",gson.toJson(answer));
		//mav.addObject("answer", answer);
		mav.setViewName("answersOnQuery");
		return mav;
		}
		else{
		mav.addObject("answer","Login first");
		mav.setViewName("login");
		return mav;
		}
	}

	@RequestMapping(value = "/updateAnswerLikes/{answerId}")
	public ModelAndView updateLikes(@PathVariable int answerId,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if(session!=null && session.getAttribute("userId")!=null){
		
		
		mav.setViewName("answersOnQuery");// EDIT THE PAGE ACCORDINGLY
		Gson gson=new Gson();
		mav.addObject("answer",gson.toJson(answerService.updateLikes(answerId)));
		return mav;
		}
		else{
	//	mav.addObject("answer","Login first");
		mav.setViewName("login");
		return mav;
		}
	}

	
	@RequestMapping(value = "/updateAnswerLikes1/{answerId}")
	public @ResponseBody String updateLikes1(@PathVariable int answerId,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			Gson gson=new Gson();
			String data = gson.toJson(answerService.updateLikes(answerId));
			return data;
		}
		else{
			//	mav.addObject("answer","Login first");
//			mav.setViewName("login");
			return "Please Login to Continue";
		}
	}
	
	@RequestMapping(value="/getAnswerByAuthor/{userId}")
	public ModelAndView getAnswerByAuthor(@PathVariable int userId,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			List<Answer> answersList=answerService.getAnswerByAuthorId(userId);
			Gson gson=new Gson();
			mav.addObject("answerlistOfAuthor",gson.toJson(answersList));
		//	mav.addObject("answerlistOfAuthor", answersList);
			System.out.println("answerList "+answersList);
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
