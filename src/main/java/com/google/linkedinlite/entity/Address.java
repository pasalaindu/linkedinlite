package com.google.linkedinlite.entity;

import org.springframework.web.bind.annotation.PostMapping;

import com.google.linkedinlite.entity.util.AddressStatus;
import com.google.linkedinlite.entity.util.AddressType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int id;
	private String doorno;
	private String addressline1;
	private String addressline2;//optional
	private String landmark;
	private String city;
	private String state;
	
	private String country;
	private int pincode;
	@Enumerated(EnumType.STRING)
	private AddressStatus status=AddressStatus.ACTIVE;
	
	private AddressType type=AddressType.PERMENENT;//enum--> permenent || present ||work ||
	
	@ManyToOne
	private Employee employee;

		

}


//POST-->   /address/{eid}    address json obj {  }  ---->save address for a employee
//GET-->    /address/{eid}                          ----->       fetch all address of an employee


//GET-->    /address/{aid}                         ---> fatch a address by its id

//PATCH--->   /address/type/{aid}/{tye}           -----> change the address type by id

//Patch--> /address/status/{aid}/{sattus} ------> change the status of an address by its id
//
//
//
//
//
//
//
