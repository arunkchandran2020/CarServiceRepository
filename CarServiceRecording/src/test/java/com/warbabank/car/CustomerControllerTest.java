package com.warbabank.car;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.warbabank.car.controller.CustomerController;
import com.warbabank.car.model.Customer;
import com.warbabank.car.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@Test
	public void getCustomersTest() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(101, "Peeter", "Street 1, Door3, Main Road","MainCenter"));
		customerList.add(new Customer(102, "Sam", "Street 2, Door4, Main Road","MainCenter"));
		customerList.add(new Customer(103, "John", "Street 100, Door3, Outer Road","OuterLink"));
		customerList.add(new Customer(104, "Biden", "Street 20, Door10, Inner Road","OuterLink"));
		
		try {
			when(customerService.getCustomers()).thenReturn(customerList);
			mockMvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk()).andExpect(jsonPath("$.length()", is((4))));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getCustomerDetailsTest() {
		Customer customer = new Customer(101, "Peeter", "Street 1, Door3, Main Road","MainCenter");
		try {
			when(customerService.getCustomer(101)).thenReturn(customer);
			mockMvc.perform(get("/customers/101").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.customerNme", is(customer.getCustomerNme())));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
