package com.luv2code.springdemo;

public class RandomFortuneService implements FortuneService {

	//create a constructor
	//Define an string array to store the random fortunes
	private String fortunes[] = {
			"Victory will be yours today",
			"You will have an injury ",
			"You will enjoy your game today",
			"Your tears will be wiped away",
			"a prophecy will come to pass in your life"
	};
	
	//create a method to return a random fortune each time its called 
	RandomFortuneService(){

	}
	
	@Override
	public String getFortune() {
		int length = fortunes.length;
		int rand;
		do {
			rand = (int)(Math.random() * length) + 1;
		}while(rand < 0 || rand >= length );
		
		return fortunes[rand];
	}

	@Override
	public String getRandomFortune() {
		int length = fortunes.length;
		int rand;
		do {
			rand = (int)(Math.random() * length) + 1;
		}while(rand < 0 || rand >= length );
		
		return fortunes[rand];
	}
	

}
