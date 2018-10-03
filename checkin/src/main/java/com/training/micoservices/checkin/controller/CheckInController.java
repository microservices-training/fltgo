package com.training.micoservices.checkin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.micoservices.checkin.component.CheckinComponent;
import com.training.micoservices.checkin.entity.CheckInRecord;

@RestController
@RequestMapping("/checkin")

public class CheckInController {

	CheckinComponent checkInComponent;

	@Autowired
	CheckInController(CheckinComponent checkInComponent) {

		this.checkInComponent = checkInComponent;
	}

	@RequestMapping("/get/{id}")

	Optional<CheckInRecord> getCheckIn(@PathVariable long id) {
		return checkInComponent.getCheckInRecord(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	long checkIn(@RequestBody CheckInRecord checkIn) {
		return checkInComponent.checkIn(checkIn);
	}

}
