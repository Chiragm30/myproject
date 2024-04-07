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

import com.example.demo.model.Employee;
import com.example.demo.serviceI.ServicesI;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	ServicesI ser;
	
	
	@PostMapping("/postemp")
	public Employee postemp(@RequestBody Employee e)
	{
		Employee emp=ser.postemp(e);
		return emp;
	}
	
	@GetMapping("/getemp")
	public List<Employee> getemp()
	{
	List<Employee>	list=ser.getemp();
	return list;
	}
	
	@PutMapping("/updatemp/{eid}")
	public Employee updateemp(@PathVariable("eid") Integer eid , @RequestBody Employee e)
    {
	  e.setEid(eid);
	   Employee upd=ser.updateemp(eid,e);
	   return upd;
    }

	@DeleteMapping("/deletemp/{eid}")
	public String deletemp(@PathVariable Integer eid)
	{
		ser.deletemp(eid);
		return "delete sucessfully";
	}
}
