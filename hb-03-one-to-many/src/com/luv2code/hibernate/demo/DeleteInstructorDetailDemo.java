package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {

			//start the transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int id = 3;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			//print the instructor detail
			System.out.println("InstructorDetail: " + instructorDetail);
			
			System.out.println("The associated instructor: " + instructorDetail.getInstructor());
			
			//delete instructorDetail
			System.out.println("Deleting InstructorDetail");
			session.delete(instructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			
			session.close();
			
			factory.close();
		}
	}

}
