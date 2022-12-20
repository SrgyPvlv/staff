package com.example.staff.exception;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CarNotFoundException(String message) {
		super(message);
	}
	
	public CarNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
}
