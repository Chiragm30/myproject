package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/Welcome")
	public String welcome()
	{
		String text="this is a private page and this page is not allowed to unauthenticated users";
	    return text;
	}
}
