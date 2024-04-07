package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.WelcomeClient;

import jakarta.ws.rs.GET;

@RestController
public class Restcontroller {

	@Autowired
	private WelcomeClient welcomeclient ;
	
	@GetMapping("/greet")
	public String getFeignclient()
	{
		String getmsg="Good Morning accesing the WELCOME API is succesful";
		String welcomemsg=welcomeclient.invokeWelcomeApi();
		return getmsg+welcomemsg;
	}
}
