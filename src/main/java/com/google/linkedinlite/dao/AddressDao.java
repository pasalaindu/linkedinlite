package com.google.linkedinlite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedinlite.entity.Address;
import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.repository.AddressRpository;
@Repository
public class AddressDao {
	@Autowired
	private AddressRpository repository;
	
	public Address saveAddress(Address address) {
		
		return repository.save(address);
	}


	public List<Address> findallAddresses() {

		return repository.findAll();
	}


	public Optional<Address> findAddressById(int id) {
		
		
		return repository.findById(id);
	}

}
