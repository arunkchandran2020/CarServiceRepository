package com.warbabank.car.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int customerId;
	private String customerNme;
	private String customerAddress;//tobe changed to Address class
	private String customerArea;// Added for future reference on area wise tracking. 
	
	public Customer() {
		super();
	}

	public Customer(int customerId, String customerNme, String customerAddress, String customerArea) {
		super();
		this.customerId = customerId;
		this.customerNme = customerNme;
		this.customerAddress = customerAddress;
		this.customerArea = customerArea;
	}

	@OneToMany(mappedBy = "customerId")
	private List<CarService> carServices;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNme() {
		return customerNme;
	}

	public void setCustomerNme(String customerNme) {
		this.customerNme = customerNme;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerArea() {
		return customerArea;
	}

	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}

	public List<CarService> getCarServices() {
		return carServices;
	}

	public void setCarServices(List<CarService> carServices) {
		this.carServices = carServices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerNme=" + customerNme + ", customerAddress="
				+ customerAddress + ", customerArea=" + customerArea 
				+  ", Car Services By "+customerNme+" =" + carServices + "]";
	}

	
}
