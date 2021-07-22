package MySpringSecurityMvc.MySpringSecurityMvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class DemoSecurityConfig {

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("john").password("test123").roles("EMPLOYEE");
		
		auth.inMemoryAuthentication().withUser("mary").password("test123").roles("MANAGER");
		
		auth.inMemoryAuthentication().withUser("susan").password("test123").roles("ADMIN");
	}
	
}
