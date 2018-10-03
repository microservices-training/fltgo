package com.training.micoservices.checkin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.micoservices.checkin.entity.CheckInRecord;
import com.training.micoservices.checkin.repository.CheckInRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CheckinApplication implements CommandLineRunner {
	
	@Autowired
	CheckInRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CheckinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CheckInRecord record=new CheckInRecord("Ty","Anand","28A",new Date(),"BF101","28-OCT-18",1);
		
		repository.save(record);
	}
}
