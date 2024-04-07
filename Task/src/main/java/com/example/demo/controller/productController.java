package com.example.demo.controller;

import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.ServiceI.productService;
import com.example.demo.ServiceI.userServicesI;



@RestController
@RequestMapping("/api/product")
public class productController {

	@Autowired
	private productService pser;
	
	@Autowired
	private userServicesI usr;
	
	@PostMapping(value="/insertP")
	public ResponseEntity<Product> insertProduct(@Validated @RequestBody Product product ,Principal principal) throws AccessDeniedException
	{
		if(isUserAdmin(principal.getName()))
		{
			Product ip=pser.insertProduct(product);
			 return new ResponseEntity<Product>(ip,HttpStatus.CREATED);
		}
		else {
			throw new AccessDeniedException("Don't have permission to  insert product except Admin");
		}
	 
     }
	
	private Boolean isUserAdmin(String username) {
		Boolean Usercheck = usr.isUserAdmin(username);
	
		return Usercheck;
	}

	@GetMapping("/searchP/{proname}")
	public ResponseEntity<Product> searchProduct(@PathVariable String proname)
	{
		     Product psearch=pser.searchProduct(proname);
		     System.out.println(psearch.getProname());
		     return new ResponseEntity<Product>(psearch , HttpStatus.OK);
	}
}
