package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Model.User;
import com.example.demo.repository.userRepository;
import com.example.demo.service.Iuserservice;

@org.springframework.stereotype.Service
public class Service implements Iuserservice {

	@Autowired
	private userRepository userrepo;
	
	@Override
	public User registerUser(User user) {
		return userrepo.save(user);
	}

}
