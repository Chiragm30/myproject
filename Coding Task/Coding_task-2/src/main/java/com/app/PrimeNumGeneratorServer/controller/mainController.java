package com.app.PrimeNumGeneratorServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.PrimeNumGeneratorServer.Entity.PrimeNumRequest;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNumResponse;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNum;
import com.app.PrimeNumGeneratorServer.seviceI.PrimeServiceI;

@RestController
@RequestMapping("/pcontoller")
public class mainController {
	
	@Autowired
	private PrimeServiceI psrv;
  
	
	@PostMapping(value="/getexecutionDetails")
	public PrimeNumResponse CalculatePrimeNumber(@RequestBody PrimeNumRequest pRequest)
	{
		//take a primeNumber and elapsedtTime as a Response
		PrimeNumResponse pResponse=psrv.CalculatePrimeNumber(pRequest);
		return pResponse;
	  
	}
	
}
