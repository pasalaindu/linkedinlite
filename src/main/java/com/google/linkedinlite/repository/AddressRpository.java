package com.google.linkedinlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.linkedinlite.entity.Address;

public interface AddressRpository extends JpaRepository<Address, Integer> {

}
