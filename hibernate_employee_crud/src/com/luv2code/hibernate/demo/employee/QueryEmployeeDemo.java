package com.luv2code.hibernate.demo.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

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
		
		//Query for all employees
		List<Employee> employees = session.createQuery("from Employee").getResultList();
		
		extracted(employees);
		
		System.out.println();
		
		//Query for all firstname=Derek
		List<Employee> employee = session.createQuery("from Employee e WHERE e.first_name='Derek'").getResultList();
		
		extracted(employee);
		
		System.out.println();
		
		//Query for all firstname=Derek or Lastname=Derek
		List<Employee> employee2 = session.createQuery("from Employee e WHERE e.first_name='Derek' OR e.last_name='Derek'").getResultList();
		
		extracted(employee2);
		
		System.out.println();
		
		//Query for all companies that ends with Switch
		List<Employee> employee4 = session.createQuery("from Employee e WHERE e.company LIKE '%Switch'").getResultList();
		
		extracted(employee4);
	
		//commit the transactions
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
	}

	private static void extracted(List<Employee> employees) {
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	}

}
