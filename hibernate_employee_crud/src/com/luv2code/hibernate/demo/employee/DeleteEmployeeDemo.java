package com.luv2code.hibernate.demo.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		//create/import factory manager
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session from factory manager
		Session session = factory.getCurrentSession();
		
		//create employee objects
//		Employee employee1 = new Employee("Mbah", "Derek", "DunesArt");
//		Employee employee2 = new Employee("Dunes", "Derek", "Lloydant");
//		Employee employee3 = new Employee("Derek", "Fisher", "InterSwitch");
		
		//start the session transaction
		session.beginTransaction();
		
		//Get the ID of an employees
//		int id = 19;
//		Employee emp = session.get(Employee.class, id);
//		
//		session.delete(emp);
		
		//Updating all Employee company to switch
		session.createQuery("DELETE from Employee ").executeUpdate();
		
		//commit the transactions
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
	}

}
