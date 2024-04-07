package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UsernameNotFoundException extends RuntimeException {
     
	public UsernameNotFoundException(String msg)
	{
		super(msg);
	}
}
