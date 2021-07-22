package com.lu2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> account = accountDao.findAccounts();
		
		System.out.println("\n\nMain Program: AfterReturning DemoApp");
		System.out.println("----");
		
		System.out.println(account);
		
		System.out.println("\n");
		//close the context
		context.close();
	}

}
