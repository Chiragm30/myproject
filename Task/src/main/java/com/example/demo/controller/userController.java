package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.ServiceI.userServicesI;

@RestController
@RequestMapping("/api/users")
public class userController {

	@Autowired
	private userServicesI usr;
	
	@PostMapping(value="/create")
	public ResponseEntity<User> createUser(@Validated @RequestBody User user)
	{
		  User cuser =usr.createUser(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	
}
