package com.warbabank.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warbabank.car.model.CarService;

public interface CarServiceRepository extends JpaRepository<CarService, Integer>{
	
	List<CarService> findByCarName(String carName);
}
