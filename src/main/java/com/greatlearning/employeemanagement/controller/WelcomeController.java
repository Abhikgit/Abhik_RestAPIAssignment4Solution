package com.greatlearning.employeemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WelcomeController {
	
	@RequestMapping("/")
	public String handelWelcomePage() {
		return "welcome";
	}

}
