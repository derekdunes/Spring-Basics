package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Perform 30 press ups every morning";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
