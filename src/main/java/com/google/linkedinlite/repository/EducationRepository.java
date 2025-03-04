package com.google.linkedinlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.linkedinlite.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {
	
	


}
