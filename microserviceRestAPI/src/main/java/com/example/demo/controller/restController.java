package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String welcome()
	{
//to display current server port number
	String	port=env.getProperty("server.port");
		
		String msg="Welcome to my microservice page...!!!!" +"(port ::"+port+")";      
		return msg;
	}
}
