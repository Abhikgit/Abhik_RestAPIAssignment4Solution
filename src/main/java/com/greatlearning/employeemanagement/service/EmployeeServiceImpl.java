package com.greatlearning.employeemanagement.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagement.entity.Data;
import com.greatlearning.employeemanagement.repository.DataRepository;

@Repository
public class EmployeeServiceImpl 
	implements EmployeeService{

	@Autowired
	private DataRepository employeeRepository;
	
	@Override
	public List<Data> findAll() {
		
		return employeeRepository.findAll();
	}
	
	
	public void save(Data theEmployee) {

		employeeRepository.save(theEmployee);

	}


	public Data findById(int id) {

		return employeeRepository.findById(id).get();
	}


	@Override
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);
		
	}
	

}	
