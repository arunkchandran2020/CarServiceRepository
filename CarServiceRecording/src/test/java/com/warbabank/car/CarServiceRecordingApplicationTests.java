package com.warbabank.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.warbabank.car.model.CarService;
import com.warbabank.car.model.Customer;
import com.warbabank.car.repository.CarServiceRepository;
import com.warbabank.car.repository.CustomerRepository;
import com.warbabank.car.service.CarServices;
import com.warbabank.car.service.CustomerService;

@SpringBootTest
class CarServiceRecordingApplicationTests {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CarServices carServices;
	
	@MockBean
	CarServiceRepository carServiceRepository;
	
	@MockBean
	CustomerRepository customerRepository;


	@Before
	public void setUp() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(101, "Peeter", "Street 1, Door3, Main Road","MainCenter"));
		customerList.add(new Customer(102, "Sam", "Street 2, Door4, Main Road","MainCenter"));
		customerList.add(new Customer(103, "John", "Street 100, Door3, Outer Road","OuterLink"));
		customerList.add(new Customer(104, "Biden", "Street 20, Door10, Inner Road","OuterLink"));
		
		List<CarService> carService = new ArrayList<CarService>();
		carService.add(new CarService(1,100,101,"Bens","FirstService","Done Full service",null));
		carService.add(new CarService(2,100,101,"Benz","FirstService","Done Full service",null));
		carService.add(new CarService(3,100,101,"Benz","FirstService","Done Full service",null));
		carService.add(new CarService(4,100,104,"Bens","FirstService","Done Full service",null));
	}


	@Test
	void getCustomersTest() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(101, "Peeter", "Street 1, Door3, Main Road","MainCenter"));
		customerList.add(new Customer(102, "Sam", "Street 2, Door4, Main Road","MainCenter"));
		customerList.add(new Customer(103, "John", "Street 100, Door3, Outer Road","OuterLink"));
		customerList.add(new Customer(104, "Biden", "Street 20, Door10, Inner Road","OuterLink"));
		
		try {
			when(customerRepository.findAll()).thenReturn(customerList);
			assertEquals(customerService.getCustomers().size(), 4);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getCustomerTest() {
		Customer customer = new Customer(101, "Peeter", "Street 1, Door3, Main Road","MainCenter");
		try {
			when(customerRepository.findByCustomerId(101)).thenReturn(customer);
			assertEquals(customerService.getCustomer(101).getCustomerId(), 101);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getCarServicesTest() {
		List<CarService> carService = new ArrayList<CarService>();
		carService.add(new CarService(1,100,101,"Bens","FirstService","Done Full service",null));
		carService.add(new CarService(2,100,101,"Benz","FirstService","Done Full service",null));
		carService.add(new CarService(3,100,101,"Benz","FirstService","Done Full service",null));
		carService.add(new CarService(4,100,104,"Bens","FirstService","Done Full service",null));
		try {
			when(carServiceRepository.findByCarName("Benz")).thenReturn(carService);
			assertEquals(carServices.getCarServices("Benz").size(),4);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	void addCarServiceTest(){
		CarService carService = new CarService(1,100,101,"Bens","FirstService","Done Full service",null);
		
		try {
			when(carServiceRepository.save(carService)).thenReturn(carService);
			assertEquals(carServices.addCarService(carService),carService);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
