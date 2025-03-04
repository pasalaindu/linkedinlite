package com.google.linkedinlite.responsestructure;

import java.util.ArrayList;
import java.util.List;

import com.google.linkedinlite.entity.Address;
import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ResponseStructure<T> {
	private int status ;
	private String  message;
	private T body;
	
	
	

	

}
