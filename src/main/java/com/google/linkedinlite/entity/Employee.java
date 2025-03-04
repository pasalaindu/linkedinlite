package com.google.linkedinlite.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.google.linkedinlite.Experience;
import com.google.linkedinlite.entity.util.EmployeeStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	@CreationTimestamp
	private LocalDate dateofjoin;
	private String email;
	private double salary;
	private long phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Experience experience=Experience.FRESHER;  //enum-->EXPERIENCED|| FRESHER
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status=EmployeeStatus.ACTIVE;  //enum-->ACTIVE||IN ACTICVE||BLOCKED
	
}

//POST     --->      /employees       json obj employe{data}      --> save an employee

//GET        --->    /employees                               ----> fetch all employees


//GET       ----->   /employees/{eid}                       -----> fetch an employee by id


//POST    ------>  /employees/login    json obj login {}     ---> login verification by email and password

