package com.microservices.ui.Exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg)
	{
		super(msg);
	}
	
}
