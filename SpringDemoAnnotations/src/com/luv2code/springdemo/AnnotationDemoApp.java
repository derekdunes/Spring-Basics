package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read the bean config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		Coach coach = context.getBean("snookerCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		//call a method on the bean
		System.out.println(coach.getDailyFortune());
		
		//close the context
		context.close();

	}

}
