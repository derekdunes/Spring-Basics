package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			//start the transaction
			session.beginTransaction();
			
			//option 2: Hibernate Query with HQL
			int id = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i JOINFETCH i.courses where i.id=:theInstructorId");
			
			//set parameter on query
			query.setParameter("theInstructorId", id);
			
			//execute query and get the instructor
			Instructor instructor = query.getSingleResult();
			
			//print the instructor
			System.out.println("Luv2Code: Instructor" + instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			//get course for the instructor
			System.out.println("\n   Luv2Code: The session is closed\n");
			
			//get course for the instructor
			System.out.println("Luv2Code: Courses" + instructor.getCourses());
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
