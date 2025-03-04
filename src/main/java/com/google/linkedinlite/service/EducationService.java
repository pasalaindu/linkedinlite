package com.google.linkedinlite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.linkedinlite.dao.EducationDao;
import com.google.linkedinlite.dao.EmployeeDao;
import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.entity.util.EductionStatus;
import com.google.linkedinlite.responsestructure.ResponseStructure;
@Service
public class EducationService {
	
	@Autowired
	private EducationDao educationDao;
	@Autowired
	private EmployeeDao employeeDao;

	public ResponseStructure<Education> saveEducation(Education education,int eid) {
		
		Optional<Employee> optional = employeeDao.findEmployeeById(eid);
		if(optional.isEmpty()) {
			//throw new invalid employee exception
		}
		Employee employee=optional.get();
		
		education.setEmployee(employee);
		
		education=educationDao.saveEducation(education);
		ResponseStructure<Education> structure=new ResponseStructure<>();
	
		structure.setStatus(200);
		structure.setMessage("education saved successfully");
		structure.setBody(education);
		return structure;
	}

	public ResponseStructure<List<Education>> findalleducationsByEmployeeById(int eid) {
		
		List<Education> el=educationDao.findalleducations();
		
		if(el.isEmpty()) {
			
			// throw
		}
			ArrayList<Education> fel=new ArrayList<>();
			
			for(Education edu:el)
			{
				Employee emp=edu.getEmployee();
				
				if(emp.getId()==eid) {
					fel.add(edu);
				}
			}
			if(fel.isEmpty()) {
				
			}
			ResponseStructure<List<Education>>structure = new ResponseStructure<>();
			
			structure.setStatus(200);
		
			structure.setMessage("all educations found successfully freom employee Id :"+eid);
			structure.setBody(fel);
			
		return structure ;
		
		}
		

	public ResponseStructure<Education> setStatusToactive(int id) {
		
		Optional<Education> optional = educationDao.findEducationById(id);
		
		if(optional.isEmpty()) {
			
			//throw InvalidEducationException();
		}
		Education education =optional.get();
		
		
	education.setEducationStatus(EductionStatus.ACTIVE);
	
		
		education=educationDao.saveEducation(education);
		
		ResponseStructure<Education> structure=new ResponseStructure();
		structure.setStatus(200);
	
		structure.setMessage(" education status updated to ACTIVE successfully ..");
		
		structure.setBody(education);
		
	
		return structure;
	}
		
}





