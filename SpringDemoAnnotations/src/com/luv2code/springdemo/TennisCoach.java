package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TennisCoach(){
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService
	){
		System.out.println(">> TennisCoach: inside default constructor using @Auto and @Quakifier");
		this.fortuneService = fortuneService;
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: inside doMyStartUpStuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	//define the setter method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuneService() method");
//		this.fortuneService = fortuneService; 
//	}
	
	
	//define the setter method
//	@Autowired
//	public void doSomethingCrazy(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside doSomethingCrazy() method");
//		this.fortuneService = fortuneService; 
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
