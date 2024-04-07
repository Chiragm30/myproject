package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String welcome()
	{
		String str="Welcome to my spring security project";
		return str;
	}
	
	@GetMapping("/about")
	public String about()
	{
		String str1="chirag anil mahant";
		return str1;
	}
	
	@GetMapping("/balance")
	public String balance()
	{
		String str2="my balance is ::125000";
		return str2;
	}
	
	@GetMapping("/transfer")
	public String transfer()
	{
		String st="funds is intiated";
		return st;
	}
}
