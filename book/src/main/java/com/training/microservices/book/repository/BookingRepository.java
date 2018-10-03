package com.training.microservices.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservices.book.entity.BookingRecord;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
	
}
