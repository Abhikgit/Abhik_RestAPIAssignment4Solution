package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Data;

public interface EmployeeService {


List<Data> findAll();
	
	void save(Data theemployee);
	
	Data findById(int theId);
	
	void deleteById(int theId);
	
}

