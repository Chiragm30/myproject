package com.microservices.ui.servicesInterface;

import java.util.List;

import com.microservices.ui.Entity.Employee;
import com.microservices.ui.model.EmployeeRequest;
import com.microservices.ui.model.EmployeeResponse;


public interface Services {

	long postEmp(EmployeeRequest employeeReq);

	EmployeeResponse getEmployeeById(long employeeId);
	
	
}
