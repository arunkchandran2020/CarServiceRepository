package com.warbabank.car.service;

import java.util.List;

import com.warbabank.car.exception.CarServicesNotFoundException;
import com.warbabank.car.model.CarService;

public interface CarServices {
	
	List<CarService> getCarServices(String carName) throws CarServicesNotFoundException; 
	
	CarService addCarService(CarService carService) throws Exception;

}
