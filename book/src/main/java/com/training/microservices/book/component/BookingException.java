package com.training.microservices.book.component;

public class BookingException extends RuntimeException  {
	
	public BookingException(String message){
		super(message);
	}
}
