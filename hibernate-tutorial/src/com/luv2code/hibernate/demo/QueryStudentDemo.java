package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();
			
			//query the students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(students);
			
			// query students: lastName='Doe'
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			//display students
			System.out.println("\n\nStudents who have last name of Doe or first name of Daffy");
			displayStudents(students);
			
			// query students: lastName='Doe' or firstName='Daffy'
			students = session.createQuery("from Student s where" + 
											" s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

			//display students
			System.out.println("\n\nStudents who have last name of Doe OR first name of Daffy");
			displayStudents(students);
			
			// query students: 
			students = session.createQuery("from Student s where " + " s.email LIKE '%Luvs2code.com'").getResultList();

			//display students
			System.out.println("\n\nStudents who have email Like Luvs2code");
			displayStudents(students);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		//display the students
		for(Student student : students ) {
			System.out.println(student);
		}
	}

}
