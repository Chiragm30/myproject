package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {
	
	@Autowired
	RestTemplate rt;

	@GetMapping("/getconsumeData")
	public List getListData()
	{
		String url="http://localhost:8081/getproduce";
		List al=rt.getForObject(url, List.class);
		return al;
	}
}
