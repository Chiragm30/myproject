package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to my jdbc Authentcation";
	}
	
	@GetMapping("/admin")
	public String adminprocess()
	{
		return "Welcome to my Admin server";
	}
	
	@GetMapping("/user")
	public String userprocess()
	{
		return "Welcome to my User process";
	}
	
}
