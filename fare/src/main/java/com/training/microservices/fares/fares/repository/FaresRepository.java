package com.training.microservices.fares.fares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservices.fares.fares.entity.*;

public interface FaresRepository extends JpaRepository<Fare,Long>{
	
	Fare getFareByFlightNumberAndFlightDate(String flightNumber,String flightDate);

}
