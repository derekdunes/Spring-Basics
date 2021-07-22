package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController{
	
	//Create request mapping route and create the return method
	@RequestMapping("/showForm")
	public String sillyForm() {
		return "helloworld-form";
	}
	
}