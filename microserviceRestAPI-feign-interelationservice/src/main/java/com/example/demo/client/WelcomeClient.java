package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// this name is same as refrence service name
// we can also used url but not recomanded
//url="http://localhost:8081/welcome"


@FeignClient(name="WELCOME-API")
public interface WelcomeClient {

	@GetMapping("/welcome")
	public String invokeWelcomeApi();
}
