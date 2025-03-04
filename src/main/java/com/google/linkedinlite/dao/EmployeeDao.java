package com.google.linkedinlite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedinlite.entity.Address;
import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.repository.EmployeeRespository;

@Repository
public class EmployeeDao {
	
	@Autowired
	
	private EmployeeRespository repository;

	public Employee saveEmployee(Employee employee) {
		
		
		return repository.save(employee);
	}

	public Optional<Employee> findEmployeeById(int eid) {
		
		return repository.findById(eid);
	}



	public List<Employee> findAllActiveEmployees() {
		
		return repository.findAllActiveEmployees();
	}



	public List<Employee> findAllEmployees() {
		
		return repository.findAll();
	}


	public List<Employee> findAllInActiveEmployees() {
	
		return repository.findAllInActiveEmployees();
	}

	
	


	


}
