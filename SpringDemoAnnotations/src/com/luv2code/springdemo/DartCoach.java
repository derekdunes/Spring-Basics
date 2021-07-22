package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DartCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public DartCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "throw 1000 darts per day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
