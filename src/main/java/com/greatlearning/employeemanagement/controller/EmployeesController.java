package com.greatlearning.employeemanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.employeemanagement.service.EmployeeService; 
import com.greatlearning.employeemanagement.entity.Data;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	EmployeeService employeeService;


@RequestMapping("/list")	
public String handleEmployeeListing(Model model) {
	
	List<Data> theemployees =employeeService.findAll();
	model.addAttribute("employees" , theemployees);
	
	
	return "employee-lister";
}

@RequestMapping(value = "/403")
public ModelAndView accesssDenied(Principal user) {

	ModelAndView model = new ModelAndView();

	if (user != null) {
		model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
	} else {
		model.addObject("msg", "You do not have permission to access this page!");
	}

	model.setViewName("403");
	return model;

}

}