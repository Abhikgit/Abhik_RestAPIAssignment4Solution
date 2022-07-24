package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.employeemanagement.entity.Data;
import com.greatlearning.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/add-begin")
	public String handleAddEmployeeBegin(Model model) {

		// create model attribute to bind form data
		Data employee = new Data();

		model.addAttribute("employee", employee);

		return "employee-details";
	}
	
	@RequestMapping("/update-begin")
	public String handleUpdateEmployeeBegin(
		@RequestParam("employeeId") int employeeId, 
		Model model) {

		Data employee = employeeService.findById(employeeId);

		model.addAttribute("employee", employee);

		return "employee-details";
	}
	

	
	@PostMapping("/save")
	public String saveEmployee(
		@RequestParam("employeeId") int employeeId, 
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName, 
		@RequestParam("email") String email) {

		System.out.println(employeeId);
		Data employee = null;
		if (employeeId != 0) {
			
			employee = employeeService.findById(employeeId);
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			
		} else{
			
			// Add flow
			employee = new Data(firstName, lastName, email);
		}
		
		employeeService.save(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";

	}	
	
	@RequestMapping("/delete")
	public String delete(
		@RequestParam("employeeId") int employeeId) {

		employeeService.deleteById(employeeId);

		return "redirect:/employees/list";

	}
}

