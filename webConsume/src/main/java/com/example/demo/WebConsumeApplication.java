package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebConsumeApplication {

	public static void main(String[] args) {
		System.out.println("consume application ");
		SpringApplication.run(WebConsumeApplication.class, args);
	}
	
	@Bean
	//rest template ka bean create kiya hai
	// bean creation class
	// resttemplate used to call one appplication to another application
	// purpose - api ko call karneke liye resttemplate ka bean create kiya hai 
	public RestTemplate rt()
	{
		RestTemplate r = new RestTemplate();
		return r;
	}

}
