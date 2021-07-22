package com.lu2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterthrowingDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> account = null;
		
		try {
			
			//add a boolean flag
			boolean tripWire = true;
			account = accountDao.findAccounts(tripWire);
			
		} catch (Exception e) {
			
			System.out.println("\n\nMain Program ... caugth exception: " + e);
		
		}
		
		
		System.out.println("\n\nMain Program: AfterReturning DemoApp");
		System.out.println("----");
		
		System.out.println(account);
		
		System.out.println("\n");
		//close the context
		context.close();
	}

}
