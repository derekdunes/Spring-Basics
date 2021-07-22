package spring_security_test.derek.spring.security.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class DemoSecurityConfig {

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("john").password("{noop}test123").roles("EMPLOYEE");
		
		auth.inMemoryAuthentication().withUser("mary").password("{noop}test123").roles("MANAGER");
		
		auth.inMemoryAuthentication().withUser("susan").password("{noop}test123").roles("ADMIN");
	}
	
}
