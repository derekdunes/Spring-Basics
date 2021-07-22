package com.lu2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO mDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		
		//call the business method
		accountDao.addAccount(account, true);
		accountDao.doWork();
		
		//assign values to setters
		accountDao.setName("Derek");
		accountDao.setServiceCod("Silver");
		
		//get the assign values
		String name = accountDao.getName();
		String cod = accountDao.getServiceCod();
		//call the membership business method
		mDao.addSillyMember();
		mDao.goToSleep();
		
		//call the biz method again
		System.out.println("\n let's call it again!\n");
		accountDao.addAccount(account, true);
		mDao.addSillyMember();
		
		//close the context
		context.close();
	}

}
