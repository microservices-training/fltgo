package com.training.microservices.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservices.book.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
}
