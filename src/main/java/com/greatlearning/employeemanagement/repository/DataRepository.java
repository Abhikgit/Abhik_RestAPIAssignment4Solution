
package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.entity.Data;



public interface DataRepository extends JpaRepository<Data,Integer> {
		
	
}
