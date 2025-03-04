package com.google.linkedinlite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.linkedinlite.dao.EmployeeDao;
import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.responsestructure.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	
	private EmployeeDao dao;
	
		
	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		
		employee= dao.saveEmployee(employee);
		
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		
		structure.setStatus(200);
		structure.setMessage("employee saved successfully");
		structure.setBody(employee);
		
		return structure;
	}


	public ResponseStructure<List<Employee>> findAllEmployees() {
		
	    	List<Employee> emps= dao.findAllEmployees();
	    	if(emps.isEmpty()) {
	    		
	    		//throw new noemployeefound exception();
	    	}
	    	
			ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
			structure.setStatus(200);
			structure.setMessage("all employees found successfully");
			structure.setBody(emps);
		
		return structure;
	}


	public ResponseStructure<List<Employee>> findAllActiveEmployees() {

		
    	List<Employee> emps= dao.findAllActiveEmployees();
    	
    	if(emps.isEmpty()) {
    		
    		//throw new noemployeefound exception();
    	}
    	
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		
		structure.setStatus(200);
		structure.setMessage("all employees found successfully");
		structure.setBody(emps);
	
	return structure;
}

	public ResponseStructure<Employee> findEmployeeById(int id) {
		
		Optional<Employee> optional=dao.findEmployeeById(id);
		
		if(optional.isEmpty()) {
			//throw new noemployeefound exception();
			
		}
		
		
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Employee employee=optional.get();
		
		structure.setStatus(200);
		
		structure.setMessage("all employees found successfully");
		
		structure.setBody(employee);

		return structure;
	}


	public ResponseStructure<List<Employee>> findAllInActiveEmployees() {
		
      List<Employee> emps= dao.findAllInActiveEmployees();
    	
    	if(emps.isEmpty()) {
    		
    		//throw new noemployeefound exception();
    	}
    	
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		
		structure.setStatus(200);
		structure.setMessage("all employees found successfully");
		structure.setBody(emps);
	
	return structure;
}
 
		
	

	

}
