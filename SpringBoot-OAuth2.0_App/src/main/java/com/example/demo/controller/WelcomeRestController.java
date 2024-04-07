package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class WelcomeRestController {

	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to my OAuth page ";
	}
}
