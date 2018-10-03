package com.training.microservices.fares.fares.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.microservices.fares.fares.entity.Fare;
import com.training.microservices.fares.fares.repository.FaresRepository;

@Component
public class FaresComponent {
	
	FaresRepository faresRepository;
	
	public FaresComponent() {
		
	}

	@Autowired
	public FaresComponent(FaresRepository faresRepository) {
		this.faresRepository = faresRepository;
	}
	
	public Fare getFare(String flightNumber,String flightDate)
	{
		return faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
	}
	

}
