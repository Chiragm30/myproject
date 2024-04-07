package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.service.Iuserservice;


@Controller
@RestController("/userRegister")
public class UserController {

	@Autowired
	private Iuserservice ser;
	

    @PostMapping(value ="/uRegister")
    public ResponseEntity<User> registerUser(@Validated @RequestBody User user) 
    {
        if (user.getUserId()==0) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        User userreg = ser.registerUser(user);
        return  new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }











}
