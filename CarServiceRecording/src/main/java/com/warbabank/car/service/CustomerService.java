package com.warbabank.car.service;

import java.util.List;

import com.warbabank.car.model.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers() throws Exception;
	
	public Customer getCustomer(int customerId) throws Exception;

}
