
package spring_security_test.derek.spring.security.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("john").password("{noop}test123").roles("EMPLOYEE");
		
		auth.inMemoryAuthentication().withUser("mary").password("{noop}test123").roles("MANAGER");
		
		auth.inMemoryAuthentication().withUser("susan").password("{noop}test123").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
		.loginPage("/showLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll();
	}
	
}
