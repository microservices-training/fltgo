package com.training.microservices.fares.fares.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.fares.fares.component.FaresComponent;
import com.training.microservices.fares.fares.entity.Fare;

@RestController
@RequestMapping("/fares")
public class FaresController {
	
	FaresComponent faresComponent;

	@Autowired
	public FaresController(FaresComponent faresComponent) {
		super();
		this.faresComponent = faresComponent;
	}
	
	@RequestMapping("/get")
	Fare getFare(@RequestParam(value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate) {
		return faresComponent.getFare(flightNumber, flightDate);
		
			
}

}
