package com.warbabank.car.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warbabank.car.exception.CustomerNotFoundException;
import com.warbabank.car.model.Customer;
import com.warbabank.car.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public List<Customer> getCustomers() throws Exception {
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerRepository.findAll();
		return customers;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByCustomerId(customerId);
		if(null==customer) {
			throw new CustomerNotFoundException("Customer with given ID :"+customerId+" is not found.");
		}else {
			return customer; 
		}
	}
	
	

}
