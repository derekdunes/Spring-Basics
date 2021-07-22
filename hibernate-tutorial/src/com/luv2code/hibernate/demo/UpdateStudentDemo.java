package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();

			int studentId = 1;
			
			System.out.println("\nGetting student with id: " + studentId);
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			student.setFirstName("Scooby");
			
			//update the email for all students
			System.out.println("Update email for all students");
			session.createQuery("UPDATE Student set email='foo@gmail.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
