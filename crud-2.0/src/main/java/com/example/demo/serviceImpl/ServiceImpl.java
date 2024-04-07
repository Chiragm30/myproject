package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.Repositoryemp;
import com.example.demo.serviceI.ServicesI;

@Service
public class ServiceImpl implements ServicesI{

	@Autowired
	Repositoryemp re;
	
	@Override
	public Employee postemp(Employee e) {
	
		return re.save(e);
	}

	@Override
	public List<Employee> getemp() {
		
		return re.findAll();
	}

	@Override
	public Employee updateemp(Integer eid, Employee e) {
		Optional<Employee> emp=re.findByeid(eid);
		if(emp.isPresent())
		{
			Employee emp1=emp.get();
			emp1.setEid(e.getEid());
			emp1.setEname(e.getEname());
			emp1.setEaddr(e.getEaddr());
			return re.save(emp1);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void deletemp(Integer eid) {
		re.deleteById(eid);
	}

	
}
