package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define bean for our sad fortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define Bean for our SongCoach and inject dependency
	@Bean
	public Coach songCoach() {
		return new SongCoach(sadFortuneService());
	}
	
	
	
}
