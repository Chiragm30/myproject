package com.microservices.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccController {

	@GetMapping("/status/check")
	public String Status()
	{
		return "account service working";
	}
}
