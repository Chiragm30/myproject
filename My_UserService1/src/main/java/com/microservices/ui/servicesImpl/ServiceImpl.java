package com.microservices.ui.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.ui.Entity.Employee;
import com.microservices.ui.Exception.EmployeeNotFoundException;
import com.microservices.ui.Repository.userRepository;
import com.microservices.ui.model.EmployeeRequest;
import com.microservices.ui.model.EmployeeResponse;
import com.microservices.ui.servicesInterface.Services;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ServiceImpl implements Services {

	@Autowired
	userRepository re;

	
	@Override
	public long postEmp(EmployeeRequest employeeRequest) {
		log.info("Adding Employee..");
		
		Employee employee
		    =Employee.builder()
		    .firstName(employeeRequest.getFirstName())
		    .lastName(employeeRequest.getLastName())
//		    .email(employeeRequest.getEmail())
//		    .eaddr(employeeRequest.getEaddr())
//		    .emono(employeeRequest.getEmono())
//		    .esalary(employeeRequest.getEsalary())
//		    .password(employeeRequest.getPassword())
    	    .build();
		  re.save(employee);
		  log.info("Employee created");
		  
		  return employee.getEmployeeId();
	}
	
	
	@Override
	public EmployeeResponse getEmployeeById(long employeeId) {
		log.info("Get Employee for employeeId");
		Employee employee
		 =re.findById(employeeId)
		 .orElseThrow(()->new RuntimeException("Employee with given id not found"));
		
EmployeeResponse employeerResponse = new  EmployeeResponse();
BeanUtils.copyProperties(employee, employeerResponse);
		
		return employeerResponse;
	}
	
	
//	
//	@Override
//	public Employee updateemp(Integer userId, Employee e) {
//	
//		Optional<Employee> emp =re.findByuserId(employeeId);
//		   if (emp.isPresent())
//		   {
//			   
//			   Employee emp1=emp.get();
//			   emp1.setUserId(e.getUserId());
//			   emp1.setFirstName(e.getFirstName());
//			   emp1.setLastName(e.getLastName());
////			   emp1.setEaddr(e.getEaddr());
////			   emp1.setEmono(e.getEmono());
////			   emp1.setEmail(e.getEmail());
////			   emp1.setPassword(e.getPassword());
////			   emp1.setEsalary(e.getEsalary());
//			   return re.save(emp1);
//		   }
//		   else
//		   {
//	      	return null;
//		   }
//	}
//
//	@Override
//	public void deleteemp(Integer employeeId) {
//
//		re.deleteByEmployeeId(employeeId);
//	}
//	

//	@Override
//	public Employee searchemp(String firstName) {
//		
//	Employee emp=re.findByfirstName(firstName);
//	if(emp!=null)
//	{
//		return emp;
//	}
//	else {
//		  throw new EmployeeNotFoundException("Employee not found");
//	     }
//	}

}
