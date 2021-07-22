package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use the fortune service to get a fortune
		return fortuneService.getFortune();
	}

	@Override
	public String randomDailyFortunes() {
		// TODO Auto-generated method stub
		return fortuneService.getRandomFortune();
	}
	
	
	
}
