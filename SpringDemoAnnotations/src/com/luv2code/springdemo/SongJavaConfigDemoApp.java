package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SongJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the bean config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		SongCoach coach = context.getBean("songCoach", SongCoach.class);
		
		
		//call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		//call a method on the bean
		System.out.println(coach.getDailyFortune());
		
		//call our new swim coach methods ... has the props values injected
		System.out.println("Email: " + coach.getEmail());
		System.out.println("Team: " + coach.getTeam());
		//close the context
		context.close();

	}

}
