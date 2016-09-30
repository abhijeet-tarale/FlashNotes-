package com.psl.flashnotes.Idao;

import java.util.List;

import com.psl.flashnotes.bean.Course;

public interface ICourseDAO {

	public Course addCourse(Course c);

	public List<Course> getAllCourse();

	public Course getCourseById(int id);

	public Course getCourseByName(String courseName);

}
