package spring_security_test.derek.spring.security.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";
	}
	
}
