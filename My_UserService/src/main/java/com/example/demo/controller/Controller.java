package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.serviceI.Services;
import com.example.demo.student.student;

@RestController
@RequestMapping("/stuapi")
public class Controller {
	
	@Autowired
	Services ser;
	
	
	@PostMapping("/poststu")
	public student poststu(@RequestBody student s)
	{
		student stu=ser.poststu(s);
		return stu;
	}
	
	@GetMapping("/getstu")
	public List<student> getstu()
	{
		  List<student> list=ser.getstu();
		  return list;
	}
	
	@PutMapping("/updatestu/{sid}")
	public student updatestu(@PathVariable("sid") Integer sid ,@RequestBody student s)
	{
		s.setSid(sid);
		student st=ser.updatestu(sid,s);
		return st;
	}
	
	@DeleteMapping("deletestu/{sid}")
		public String deletestu(@PathVariable Integer sid )
		{
			ser.deletestu(sid);
			return "sucessfully delete";
		}
}


