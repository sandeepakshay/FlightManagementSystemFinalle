package com.capgemini.project.exceptions;

public class FlightException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public FlightException(String msg) {
		super(msg);
	}

}
