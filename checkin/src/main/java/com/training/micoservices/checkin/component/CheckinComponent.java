package com.training.micoservices.checkin.component;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.micoservices.checkin.entity.CheckInRecord;
import com.training.micoservices.checkin.repository.CheckInRepository;

@Component
public class CheckinComponent {
	
	CheckInRepository checkinRepository;
	Sender sender;
	
	@Autowired
	CheckinComponent(CheckInRepository checkinRepository, Sender sender) {
		
		this.checkinRepository = checkinRepository;
		this.sender = sender;
	}
	
	
	public long checkIn(CheckInRecord checkIn)
	{
		checkIn.setCheckInTime(new Date());
		long id = checkinRepository.save(checkIn).getId();
		sender.send(id);
		return id;
		
	}
	
public Optional<CheckInRecord> getCheckInRecord(long id) {
	return checkinRepository.findById(id);
}

}
