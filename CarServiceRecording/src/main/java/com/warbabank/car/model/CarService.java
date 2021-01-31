package com.warbabank.car.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CarService")
public class CarService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO,
		    generator="native"
		)
	private int serviceId;
	private int carId;
	private int customerId;
	private String carName;
	private String serviceName;
	private String serviceNotes;
	private Date serviceDate;
	
	public CarService() {
		super();
	}

	public CarService(int serviceId, int carId, int customerId, String carName, String serviceName,
			String serviceNotes, Date serviceDate) {
		super();
		this.serviceId = serviceId;
		this.carId = carId;
		this.customerId = customerId;
		this.carName = carName;
		this.serviceName = serviceName;
		this.serviceNotes = serviceNotes;
		this.serviceDate = serviceDate;
	}

	@ManyToOne
    @JoinColumn(name="customerId", insertable = false, updatable = false)
	private Customer customer;
	
	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceNotes() {
		return serviceNotes;
	}

	public void setServiceNotes(String serviceNotes) {
		this.serviceNotes = serviceNotes;
	}

	
	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	@Override
	public String toString() {
		return "CarService [serviceId=" + serviceId + ", carId=" + carId + ", customerId=" + customerId + ", carName="
				+ carName + ", serviceName=" + serviceName + ", serviceNotes=" + serviceNotes +", serviceDate=" +serviceDate+ "]";
	}

	

}
