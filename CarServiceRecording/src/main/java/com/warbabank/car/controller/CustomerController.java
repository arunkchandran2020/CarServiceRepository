package com.warbabank.car.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.warbabank.car.exception.CustomerNotFoundException;
import com.warbabank.car.model.Customer;
import com.warbabank.car.service.CustomerService;


@RestController()
public class CustomerController {
	
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomers(){
		List<Customer> customerDetails = new ArrayList<Customer>();
		try {
			customerDetails = customerService.getCustomers();
		} catch (Exception e) {
			return new ResponseEntity<String>("Unable to get Customer Details....!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(customerDetails.size()==0) {
			return new ResponseEntity<String>("Customers Details not found....!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(customerDetails, HttpStatus.OK);
		
	}
	
	@GetMapping("/customers/{customerid}")
	public ResponseEntity<?> getCustomerDetails(@PathVariable("customerid") final int customerId){
		Customer customer;
		try {
			customer = customerService.getCustomer(customerId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<String>("Unable to get Customer Details....!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}

}
