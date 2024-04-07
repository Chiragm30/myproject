package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(String msg)
	{
		super (msg);
	}
}
