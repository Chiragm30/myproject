package com.example.demo.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
public class customUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("chirag"))
		{
			return new User("chirag","Chirag123",new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("user not found !!!!!");
		}
		
	}

}
