package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeConfig {
	
	//define the fortune implementation
	@Bean
	public FortuneService codeFortuneService() {
		return new CodeFortuneService();
	}
	
	//define the coach implementation and inject its dependencies
	@Bean
	public Coach dartCoach() {
		return new DartCoach(codeFortuneService());
	}
	
	
}
