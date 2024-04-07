package com.example.demo.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//we need  to configure security thats why we create this class
//so we need to clarify which field we need to secured and which not be secure 

@AutoConfiguration
@EnableWebSecurity
public class SecurityConfiguration {

//datasource is used to create datasource object of application.properties file data
// and we need to conflict property file to security configuration class to perform authentication
	
	@Autowired
	private DataSource datasource;

//Authentication manager is used to talk to jdbc
//authentication manager are used to check given credential is correct or not	
	@Autowired
	public void authManager(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(new BCryptPasswordEncoder())// we need to tell that which security password techniq is used 
		.usersByUsernameQuery("select username,password,enabled from users where username=?")//query to load user data
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");//query to checked username and password 
	}
	
	
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((req) -> req
				.requestMatchers("/").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/user").hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated()
				).formLogin();
		return http.build();
	}
}






