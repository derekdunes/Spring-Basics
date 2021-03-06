package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class snookerCoach implements Coach {
	
	@Autowired
	@Qualifier("randFortuneService")
	FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Make sure you practice your shot";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
