package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

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
			Instructor instructor = new Instructor("Mbah", "DereK", "mbahderek@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://www.luv2code.com/youtube", "Gaming, swimming");
			
			//associate the two objects
			instructor.setInstructorDetail(instructorDetail);
			
			Instructor instructor1 = new Instructor("Chad", "Darby", "chad.darby@luv2code.com");
			
			InstructorDetail instructorDetail1 = new InstructorDetail("https://www.luv2code.com/youtube", "Luv 2 Code");
			
			//associate the two objects
			instructor1.setInstructorDetail(instructorDetail1);
			
			//start the transaction
			session.beginTransaction();
			
			//save the instructor
			//NOTE: this will also save the details object
			//because of CascadeType.ALL
			//
			System.out.println("Saving the instructor: " + instructor);
			System.out.println("Saving the instructor: " + instructor1);
			session.save(instructor);
			session.save(instructor1);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
