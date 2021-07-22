package spring_security_test.derek.spring.security.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showLanding() {
		return "landing";
	}
	
	@GetMapping("/employees")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leader";
	}
	
	@GetMapping("/systems")
	public String showSystems() {
		return "system";
	}
	@RequestMapping(value="/hello")
	public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}
	
}
