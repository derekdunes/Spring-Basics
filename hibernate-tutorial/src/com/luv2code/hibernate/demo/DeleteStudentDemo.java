package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();

			//int studentId = 1;
			
			//System.out.println("\nGetting student with id: " + studentId);
			
			//get the student from the database
			//Student student = session.get(Student.class, studentId);
			
			//delete the fetched student
			//System.out.println("Deleting Student: " + student);
			//session.delete(student);
			
			//delete the student id=2
			System.out.println("Deleting Student: id=2");
			session.createQuery("DELETE from Student where id=2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
