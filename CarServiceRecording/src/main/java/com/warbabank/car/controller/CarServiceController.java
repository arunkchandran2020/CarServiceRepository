package com.warbabank.car.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.warbabank.car.exception.CarServicesNotFoundException;
import com.warbabank.car.model.CarService;
import com.warbabank.car.service.CarServices;

@RestController
public class CarServiceController {
	
	private CarServices carServices;

	@Autowired
	public CarServiceController(final CarServices carServices) {
		this.carServices = carServices;
	}
	
	@GetMapping("/carservice/{carName}")
	public ResponseEntity<?> getServices(@PathVariable("carName") final String carName){
		
		List<CarService> carService = new ArrayList<CarService>();
		try {
			carService = carServices.getCarServices(carName);
		} catch (CarServicesNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<String>("Unable to get Car Service Details....!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<CarService>>(carService, HttpStatus.OK);
		
	}
	
	@PostMapping(value="carservice/new" , consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addService(@RequestBody CarService carService) {
		CarService newService = new CarService();
//		LocalDate localDate = LocalDate.now();
		Date currentDate = new Date();
				//Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		carService.setServiceDate(currentDate);
		try {
			newService = carServices.addCarService(carService);
		} catch (Exception e) {
			return new ResponseEntity<String>("Unable to add Car Service....!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CarService>(newService, HttpStatus.CREATED);
	}

}
