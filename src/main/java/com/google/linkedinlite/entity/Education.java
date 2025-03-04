package com.google.linkedinlite.entity;



import com.google.linkedinlite.entity.util.EductionStatus;


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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
	private String universityname;
	private double percentage;
	private int completionyear;
	
	@Enumerated(EnumType.STRING)
	
	private HeighestQualification heighestqualification=HeighestQualification.YES;//enum-->yes||no
	@Enumerated(EnumType.STRING)
	private EductionStatus educationStatus=EductionStatus.ACTIVE;//enum-->active||in active
		

	@ManyToOne
	private Employee employee;



}