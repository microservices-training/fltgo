package com.training.microservices.fares;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.microservices.fares.fares.entity.Fare;
import com.training.microservices.fares.fares.repository.FaresRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class FareApplication implements CommandLineRunner{
	
	@Autowired
	FaresRepository faresRepository;

	public static void main(String[] args) {
		SpringApplication.run(FareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Fare[] fares= {
				new Fare("BF100","28-OCT-18","101"),
				new Fare("BF101","28-OCT-18","101"),
				new Fare("BF102","28-OCT-18","102"),
				new Fare("BF103","28-OCT-18","103"),
				new Fare("BF104","28-OCT-18","104"),
				new Fare("BF105","28-OCT-18","105"),
				new Fare("BF106","28-OCT-18","106")
		};
		
		List<Fare> list=Arrays.stream(fares).collect(Collectors.toList());
		
		list.forEach(fare -> faresRepository.save(fare));;
	}
	
	
}
