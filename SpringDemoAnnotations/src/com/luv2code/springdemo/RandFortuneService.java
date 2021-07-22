package com.luv2code.springdemo;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandFortuneService implements FortuneService {
	
	private String[] randomFortunes;
	
	//create a random number generator
	private Random myRandom = new Random();
	
	@PostConstruct
	void doMyStartUpStuff() throws IOException {
		String filename = "fortunes.txt";
		
		ClassLoader classLoader = new RandFortuneService().getClass().getClassLoader();
		
		File file = new File(classLoader.getResource(filename).getFile());
		
		System.out.println("File Found : " + file.exists());
		
		String content = new String(Files.readAllBytes(file.toPath()));
		
		System.out.println(content);
		
		randomFortunes = content.split(",");
		
	}
	
	@Override
	public String getFortune() {
		//int random = (int)(Math.random() * randomFortunes.length) + 1;
		int randValue = myRandom.nextInt(randomFortunes.length);
		
		return randomFortunes[randValue];
	}

}
