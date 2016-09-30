package com.psl.flashnotes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.bean.LogIn;
import com.psl.flashnotes.bean.User;
import com.psl.flashnotes.service.CourseService;
import com.psl.flashnotes.service.LoginService;
import com.psl.flashnotes.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public ModelAndView welcome(){
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("welcome");
		Gson gson=new Gson();
		mav.addObject("courseList", gson.toJson(courseService.getAllCourse()));
		return mav;
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUp(){
		ModelAndView mav = new ModelAndView("signUp");
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request){
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isvalid = loginService.isValid(userName,password);
		if (isvalid) {
			LogIn login = loginService.getLogin(userName);
			int userId = login.getUserId();
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			Globals.userIdentity=userId;
			
			System.out.println(courseService.getAllCourse());
			ModelAndView mav = new ModelAndView("welcome");
			Gson gson=new Gson();
			mav.addObject("courseList", gson.toJson(courseService.getAllCourse()));
			List<User> topMembers = userService.getTopAnswerers();
			System.out.println("Top : " + topMembers);
			mav.addObject("LoggedInUsername", userId);
			mav.addObject("topMembers", gson.toJson(topMembers));
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("errorMsg", "Invalid Username or Password");
			return mav;
		}

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		Globals.userIdentity=0;
		mav.setViewName("/login");
		return mav;
	}

@RequestMapping("/addLogin")
	public ModelAndView addLoginDetails(HttpServletRequest request,@RequestParam String username,@RequestParam String password)
	{
		ModelAndView mav=new ModelAndView();
		
			
			
			loginService.addLoginDetails(username,password);	
			mav.setViewName("/login");
			return mav;
			
		
	}

}
