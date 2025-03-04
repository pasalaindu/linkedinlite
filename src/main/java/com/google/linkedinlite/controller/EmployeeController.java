package com.google.linkedinlite.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.responsestructure.ResponseStructure;
import com.google.linkedinlite.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@Operation(summary = "to save an employee",description ="This API is used to save an Employee object,this Api aacepts the request body of employee object which should contains the fields as follows firstname,lastname,email,password,phone and salry in the requested JSON object and its shouldnot have id field in it,if id present it performs update operation, id id not present their means it performs save operation") 
	
    @PostMapping
	
	public ResponseStructure <Employee> saveEmployee(@RequestBody Employee employee){
		
		return service.saveEmployee(employee);
		
	}
	@Operation(summary = "to fetch all employees",description = "This API is used to fetch all the  employeethe DataBase Table" )
	
	
	//@ApiResponse(value= {@ApiResponse(responseCode="200",description = "Found all employees")
	 
	@GetMapping
	
	public ResponseStructure<List<Employee>> findAllEmployees(){
		return service.findAllEmployees();
		
	}
	@Operation(summary = "To fetch all active employees",description = "This API is used to fectch all Active Employees which is present in DataBase Table" )
	@GetMapping("/status/active")
	
	
	public ResponseStructure<List<Employee>> findAllActiveEmployees(){
		
		return service.findAllActiveEmployees();
		
	}
	@Operation(summary = "To fetch all inactive employees",description = "This API is used to fetch all InActive Employees which is present in DataBase Table")
	@GetMapping("/status/inactive")
	public ResponseStructure<List<Employee>> findAllInActiveEmployees(){
		
		
		
		return service.findAllInActiveEmployees();
		
	}
	
	@Operation(summary = "To fetch an employee by Id",description = "This API is used to fetch an employee by Id API accepts path variable employee object employee id is present we get id,if it not there not there it is not present")
	@GetMapping("/{id}")
	public ResponseStructure<Employee> findEmployeeById(@PathVariable int id){
		return service.findEmployeeById(id);
		
	}
	@Scheduled( fixedRate = 2000)
	public void hi() {
		System.out.println("hi method is invoked in :"+ LocalDateTime.now());
		
		
	}
}

	