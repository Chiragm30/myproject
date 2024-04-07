package com.example.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfiguration 
{ 

	@Bean
	public SecurityFilterChain securefle(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((request) -> request
				.requestMatchers ("/","/login","/about").permitAll() //request need not add security
				.anyRequest().authenticated()  //remaining all request we provide security
				).formLogin();
		return http.build();
	} 

}
