package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session 
				Session session = factory.getCurrentSession();
				
				try {
					//create three student object
					System.out.println("Creating new student object...");
					Student tempStudent = new Student("John", "Doe", "john@Luvs2code.com");
					Student tempStudent1 = new Student("Mary", "Public", "mary@Luvs2code.com");
					Student tempStudent2 = new Student("Bonita", "Appliebum", "bonita@Luvs2code.com");
					
					//start the transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student... ");
					session.save(tempStudent);
					session.save(tempStudent1);
					session.save(tempStudent2);
					
					System.out.println(tempStudent);
					System.out.println(tempStudent1);
					System.out.println(tempStudent2);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				}finally {
				
					factory.close();
				
				}

	}

}
