package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//Create request mapping route and create the return method
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data
	//add data to the model
	@RequestMapping("/processFormv2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the html form
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		
		String fullName = firstName + " " + lastName;
				
		//convert the data to Camel case
		fullName = fullName.toUpperCase();
		
		//create the message
		String result = "Yo! " + fullName;
		
		//add message to the model
		model.addAttribute("hailing", result);
		
		return "helloworld";
		
	}
	
	//new controller method to read form data
	//add data to the model
	@RequestMapping("/processFormv3")
	public String processformversionthree(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName, Model model) {
			
			//read the request parameter from the html form
//			String lastName = request.getParameter("lastName");
//			String firstName = request.getParameter("firstName");

			String fullName = firstName + " " + lastName;
					
			//convert the data to Camel case
			fullName = fullName.toUpperCase();
			
			//create the message
			String result = "Yo! " + fullName;
			
			//add message to the model
			model.addAttribute("hailing", result);
			
			return "helloworld";
			
		}
	
	//New Controller
	
}
