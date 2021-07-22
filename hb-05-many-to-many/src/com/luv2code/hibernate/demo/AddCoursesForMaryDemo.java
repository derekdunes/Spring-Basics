package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start the transaction
			session.beginTransaction();
			//get mary from database
			int id  = 3;
			
			Student mary = session.get(Student.class, id);
			
			System.out.println("\nLoaded Student: " + mary);
			System.out.println("Student Course: " + mary.getCourses());
			
			//create more course
			Course course = new Course("Java Hibernate Course");
			Course course1 = new Course("DotNet MVC framework");
			
			//add course to mary
			mary.addCourse(course);
			mary.addCourse(course1);
			
			//Save courses 
			session.save(course);
			session.save(course1);
			
			System.out.println("Saved Course: " + course);
			System.out.println("Saved Course: " + course1);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
