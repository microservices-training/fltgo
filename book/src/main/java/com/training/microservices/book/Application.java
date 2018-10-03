package com.training.microservices.book;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.microservices.book.component.BookingComponent;
import com.training.microservices.book.entity.BookingRecord;
import com.training.microservices.book.entity.Inventory;
import com.training.microservices.book.entity.Passenger;
import com.training.microservices.book.repository.BookingRepository;
import com.training.microservices.book.repository.InventoryRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private BookingComponent bookingComponent;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Inventory[] invs = { 
					new Inventory("BF100", "28-OCT-18", 100),
					new Inventory("BF101", "28-OCT-18", 100),
					new Inventory("BF102", "28-OCT-18", 100),
					new Inventory("BF103", "28-OCT-18", 100),
					new Inventory("BF104", "28-OCT-18", 100),
					new Inventory("BF105", "28-OCT-18", 100),
					new Inventory("BF106", "28-OCT-18", 100)};
		Arrays.asList(invs).forEach(inventory -> inventoryRepository.save(inventory));
				
		 
		
		BookingRecord booking = new BookingRecord("BF101", "NYC","SFO","28-OCT-18",new Date(),"101");
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Gean","Franc","Male", booking));
	
	 	
		booking.setPassengers(passengers);
 		long record  = bookingComponent.book(booking);
		logger.info("Booking successfully saved..." + record);
		
		logger.info("Looking to load booking record..."); 
	    logger.info("Result: " + bookingComponent.getBooking(record));
 
	    
	}
	
}
