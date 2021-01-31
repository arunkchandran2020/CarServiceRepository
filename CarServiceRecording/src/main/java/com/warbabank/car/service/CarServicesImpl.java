package com.warbabank.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warbabank.car.exception.CarServicesNotFoundException;
import com.warbabank.car.model.CarService;
import com.warbabank.car.repository.CarServiceRepository;

@Service
public class CarServicesImpl implements CarServices{

	@Autowired
	CarServiceRepository carServiceRepository;

	@Override
	public List<CarService> getCarServices(String carName) throws CarServicesNotFoundException {
		
		List<CarService> carServices = carServiceRepository.findByCarName(carName);
		if(carServices==null || carServices.size()==0) {
			throw new CarServicesNotFoundException(" No Services found for the Given Car :"+carName);
		}
		return carServices;
	}

	@Override
	public CarService addCarService(CarService carService) throws Exception {
		CarService newService = carServiceRepository.save(carService);
		return newService;
	}
	
	

}
