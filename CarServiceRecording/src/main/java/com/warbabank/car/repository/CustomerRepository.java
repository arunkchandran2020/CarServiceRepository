package com.warbabank.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warbabank.car.model.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	//List<Customer> getcustomerList(); 
	
	Customer findByCustomerId(int customerId);

}
