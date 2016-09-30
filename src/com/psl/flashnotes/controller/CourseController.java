package com.psl.flashnotes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.psl.flashnotes.bean.Course;
import com.psl.flashnotes.bean.Notes;
import com.psl.flashnotes.service.CourseService;
import com.psl.flashnotes.service.NotesService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private NotesService notesService;
	
	@RequestMapping("/addCourse")
	public ModelAndView addCourse(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Course course = new Course();
		course.setCourseName(request.getParameter("courseName"));
		course.setCourseContent(request.getParameter("courseContent"));
		Gson gson=new Gson();
		mav.addObject("course", gson.toJson(courseService.addCourse(course)));
		mav.setViewName("display");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}

	}

	@RequestMapping("/getAllCourse")
	public ModelAndView getAllCourse(HttpServletRequest request) {
		System.out.println("I'm in Course Controller");
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
			List<Course> courseList = courseService.getAllCourse();
			Gson gson=new Gson();
			System.out.println(courseList);
			mav.addObject("courseList", gson.toJson(courseList));
			System.out.println("JSON : \n" + gson.toJson(courseList));
			mav.setViewName("allCourses");
			return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
		}
	}

	@RequestMapping(value = "getCourseById/{courseId}")
	public ModelAndView getCourseById(@PathVariable int courseId,HttpServletRequest request) {
		Gson gson=new Gson();
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("userId")!=null){
		Course course = courseService.getCourseById(courseId);
		List<Notes> top3Notes = notesService.getTopNotes(courseId);
		System.out.println(course);
		System.out.println(top3Notes);

		mav.addObject("course", gson.toJson(course));
		mav.addObject("topNotes", gson.toJson(top3Notes));
		mav.setViewName("course");
		return mav;
		}
		else{
			mav.addObject("answer","Login first");
			mav.setViewName("login");
			return mav;
			}
	}

	@RequestMapping(value = "getCourseByName/{courseName}", method = RequestMethod.GET)//to change to post
	public ModelAndView getCourseByName(@PathVariable String courseName,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession(false);
		Gson gson=new Gson();
		if(session!=null && session.getAttribute("userId")!=null){
		Course course = courseService.getCourseByName(courseName);
		mav.addObject("course", gson.toJson(course));
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
