package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SongCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SongCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService; 
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Sing 1000 Do Re Mes as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
