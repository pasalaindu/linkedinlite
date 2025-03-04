package com.google.linkedinlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedinlite.entity.Address;
import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.responsestructure.ResponseStructure;
import com.google.linkedinlite.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressService service;
	
	@PostMapping("/addresses/{eid}")
	
	public ResponseStructure<Address> saveAddress(@RequestBody Address address,@PathVariable int eid){
		
		return service.saveAddress(address,eid);
		
	}
	@GetMapping("/employee/{eid}")
	
	public ResponseStructure<List<Address>> findallAddressByEmployeeId(@PathVariable int eid){
		
		
		return service.findallAddressByEmployeeId(eid);
		
	}
     @PatchMapping("/status/active/{id}")
	
	public ResponseStructure<Address> setStatusToactive(@PathVariable int id){
    	 
		return service.setStatusToactive(id);
				
		
	}
	
	

}
