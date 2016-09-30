package com.psl.flashnotes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.psl.flashnotes.bean.Globals;
import com.psl.flashnotes.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		mav.setViewName("index");
		mav.addObject("name", userService.getDetails());
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login1");
			return mav;
		}
	}

	@RequestMapping("/topMembers")
	public ModelAndView getTopAnswerers(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("welcome");
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		mav.addObject("topMembers", userService.getTopAnswerers());

		return mav;
	}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
	}
	
	@RequestMapping("/user")
	public ModelAndView getAllUserDetails(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		ModelAndView mav=new ModelAndView("user");
		Gson gson=new Gson();
		mav.addObject("userData", gson.toJson(userService.getUserById(Globals.userIdentity)));
		
		System.out.println(userService.getUserById(Globals.userIdentity));
		return mav;
		}
		else{
			ModelAndView mav=new ModelAndView();
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}
	
	@RequestMapping("/user1")
	public @ResponseBody String  getAllUserDetails1(HttpServletRequest request)
	{
		String json=null;
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			Gson gson=new Gson();
			json=gson.toJson(userService.getUserById(Globals.userIdentity));
		}
		return json;
	}
}