package com.google.linkedinlite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.linkedinlite.dao.AddressDao;
import com.google.linkedinlite.dao.EmployeeDao;
import com.google.linkedinlite.entity.Address;
import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.entity.util.AddressStatus;
import com.google.linkedinlite.entity.util.EductionStatus;
import com.google.linkedinlite.responsestructure.ResponseStructure;
@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	
	public ResponseStructure<Address> saveAddress(Address address, int eid) {
		
		Optional<Employee> optional = employeeDao.findEmployeeById(eid);
		
		
		
		if(optional.isEmpty()) {
			//throw new invalid employee exception
		}
		Employee employee=optional.get();
        address.setEmployee(employee);
		
		address=addressDao.saveAddress(address);
		
		ResponseStructure<Address> structure=new ResponseStructure<>();
	
		structure.setStatus(200);
		structure.setMessage("education saved successfully");
		structure.setBody(address);
		return structure;
	}


	public ResponseStructure<List<Address>> findallAddressByEmployeeId(int eid) {
		
		List<Address> al=addressDao.findallAddresses();
		
		if(al.isEmpty()) {
			
			// throw
		}
			ArrayList<Address> fel=new ArrayList<>();
			
			for(Address ads:al) {
			
				Employee emp=ads.getEmployee();
				
				if(emp.getId()==eid) {
					
					fel.add(ads);
				}
			}
			if(fel.isEmpty()) {
				
			}
			ResponseStructure<List<Address>> structure = new ResponseStructure<>();
			
			structure.setStatus(200);
		
			structure.setMessage("all addresses found successfully from employee Id :"+eid);
			
			structure.setBody(fel);
			
		return structure ;
		
		}


	public ResponseStructure<Address> setStatusToactive(int id) {
		
  Optional<Address> optional = addressDao.findAddressById(id);
		
		if(optional.isEmpty()) {
			
			//throw InvalidEducationException();
		}
		Address address =optional.get();
		
		
	  address.setStatus(AddressStatus.ACTIVE);
	
		
		address=addressDao.saveAddress(address);
		
		ResponseStructure<Address> structure=new ResponseStructure();
		structure.setStatus(200);
	
		structure.setMessage(" address status updated to ACTIVE successfully ..");
		
		structure.setBody(address);
		
	
		return structure;
	}

		

	
}

		
		
		
	

	


