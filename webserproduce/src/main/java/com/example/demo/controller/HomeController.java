package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.student;

@RestController
//@RequestMapping("/webp")
public class HomeController {

	@GetMapping("/getproduce")
	  public List getproduce()
	  {
		  student s = new student();
		  s.setSId(1);
		  s.setSName("chirag");
		  s.setSAddr("katol");
		 List al=new ArrayList<>();
		 al.add(s);
		  return al;
		  
		  
	  }
}
