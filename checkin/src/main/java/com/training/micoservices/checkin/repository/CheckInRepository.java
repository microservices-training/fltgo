package com.training.micoservices.checkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.micoservices.checkin.entity.CheckInRecord;

public interface CheckInRepository  extends JpaRepository<CheckInRecord,Long>{

	
}
