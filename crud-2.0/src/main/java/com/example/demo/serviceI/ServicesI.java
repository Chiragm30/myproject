package com.example.demo.serviceI;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public interface ServicesI {

    public Employee postemp(Employee e);

	public List<Employee> getemp();

	public Employee updateemp(Integer eid, Employee e);

	public void deletemp(Integer eid);

	
}
