package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//Retrieve the bean from the config file
		Coach theCoach = context.getBean("trackCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("trackCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		// print out the result
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach:" + theCoach);
		
		System.out.println("\nMemory location for theCoach:" + alphaCoach);
		

	}

}
