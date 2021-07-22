package com.luv2code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		//create/import factory manager
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session from factory manager
		Session session = factory.getCurrentSession();
		
		//create employee objects
		Employee employee1 = new Employee("Mbah", "Derek", "DunesArt");
		Employee employee2 = new Employee("Dunes", "Derek", "Lloydant");
		Employee employee3 = new Employee("Derek", "Fisher", "InterSwitch");
		
		//start the session transaction
		session.beginTransaction();
		
		//print object
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		
		//save the object created
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		
		//print the object to show their new IDS
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		
		//commit the transactions
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
	}

}
