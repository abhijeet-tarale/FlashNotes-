package com.psl.flashnotes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.psl.flashnotes.Idao.ICourseDAO;
import com.psl.flashnotes.bean.Course;
import org.hibernate.Query;

@Repository
public class CourseDAO implements ICourseDAO {

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public Course addCourse(Course course) {

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(course);
		tx.commit();
		return course;
	}

	@Override
	public List<Course> getAllCourse() {
		System.out.println("Get All Courses");
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from " + Course.class.getName());
		List<Course> courseList = (List<Course>) query.list();
		System.out.println(courseList);
		tx.commit();
		return courseList;
	}

	@Override
	public Course getCourseById(int courseId) {

		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Course course = (Course) session.get(Course.class, courseId);
		tx.commit();
		return course;
	}

	@Override
	public Course getCourseByName(String courseName) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Course c where c.courseName=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", courseName);
		Course course = (Course) query.uniqueResult();
		tx.commit();
		return course;

	}
}
