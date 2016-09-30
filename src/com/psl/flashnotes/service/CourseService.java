package com.psl.flashnotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.Idao.ICourseDAO;
import com.psl.flashnotes.bean.Course;

@Service
public class CourseService {

	@Autowired
	private ICourseDAO courseDAO;

	public Course addCourse(Course course) {
		course.setDateCreated(new Date());
		course.setLastUpdated(new Date());
		return courseDAO.addCourse(course);
	}

	public List<Course> getAllCourse() {
		System.out.println("In Course Service");
		return courseDAO.getAllCourse();

	}

	public Course getCourseById(int courseId) {

		return courseDAO.getCourseById(courseId);
	}

	public Course getCourseByName(String courseName) {

		return courseDAO.getCourseByName(courseName);
	}

}
