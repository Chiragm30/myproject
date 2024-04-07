package com.appsdeveloperblog.photoapp.Api.Users.ui.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.photoapp.Api.Users.services.UsersService;
import com.appsdeveloperblog.photoapp.Api.Users.shared.UserDto;
import com.appsdeveloperblog.photoapp.Api.Users.ui.model.CreateUserResponseModel;
import com.appsdeveloperblog.photoapp.Api.Users.ui.model.CreateUsersModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
 public class UsersController {
	
	@Autowired
	 UsersService userService;
	
	@Autowired
	private Environment env;

	@GetMapping("/status/check")
	public String status()
	{
	  return "working on port" +env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUsersModel userDetails)
	{
		ModelMapper md=new ModelMapper();
		md.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		 UserDto userDto=md.map(userDetails, UserDto.class);
		
		UserDto createUser= userService.createUser(userDto);
		 
		 CreateUserResponseModel returnvalue=md.map(createUser, CreateUserResponseModel.class);
		return  ResponseEntity.status(HttpStatus.CREATED).body(returnvalue);
	}
}
