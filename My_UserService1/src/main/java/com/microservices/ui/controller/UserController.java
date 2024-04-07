package com.microservices.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.ui.Entity.Employee;
import com.microservices.ui.model.EmployeeRequest;
import com.microservices.ui.model.EmployeeResponse;
import com.microservices.ui.servicesInterface.Services;

import jakarta.validation.Valid;

@RestController
//(@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations, and as a result, 
//simplifies the controller implementation)

@RequestMapping("/Empapi")
//(RequestMapping annotation is used to map web requests into specific handler classes and/or handler methods)

public class UserController {

	@Autowired
	Services ser;
	

@GetMapping(value="/{id}")
public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") long employeeId)
	{
		EmployeeResponse employeeResponse
		    =ser.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeResponse,HttpStatus.OK);
	}
	
@PostMapping
public ResponseEntity<Long> postEmp(@Valid @RequestBody EmployeeRequest employeeReq)

	 //(The @RequestBody annotation is applicable to handler methods of Spring controllers. This annotation indicates that Spring should deserialize a request body into an object.
     //This object is passed as a handler method parameter.)
	{
	long employeeId = ser.postEmp(employeeReq);
	
	return new ResponseEntity<>(employeeId	,HttpStatus.CREATED);
	}






















//	
//	@PutMapping(value="/update/{userid}")
//	public ResponseEntity<Employee> updateemp(@Valid @PathVariable("employeeId") Integer userid ,@RequestBody Employee e )
////(The @PathVariable annotation is used to extract the value from the URI)
//	{
//		e.setEmployeeId(employeeId);
//		Employee upd = ser.updateemp(userid,e);
//		return new ResponseEntity<Employee>(upd ,HttpStatus.OK);
//	}
//	
//	
//	@DeleteMapping(value="/deleteemp/{userid}")
//	public ResponseEntity<Employee> deleteemp(@PathVariable Integer userid)
//	{
//		ser.deleteemp(userid);
//	return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
//	}
//	
//	@GetMapping(value="/searchemp/{firstName}")
//	public ResponseEntity<Employee> searchemp(@PathVariable String firstName )
//	{
//		
//		Employee seremp=ser.searchemp(firstName);
//		System.out.println(seremp.getFirstName()); 
//		return new ResponseEntity<Employee>(seremp ,HttpStatus.OK);
//	}

//	//file ulpload
//	@PostMapping(value = "/document",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
//	public List<Employee> savedocu(@RequestPart("imageupload") MultipartFile file)
//	{
//	     return null;
//	}
}
