package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Helper.Helper;
import com.example.demo.Model.University;
import com.example.demo.ServiceImpl.serviceimpl;
import com.example.demo.repository.repository;

@RestController
@RequestMapping("/univer")
public class HomeController {

	@Autowired
	private serviceimpl ser;

	
	@PostMapping("/postun")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)   
	{
		if(Helper.checkExcelFormat(file))
		{
		 this.ser.save(file);
		 return ResponseEntity.ok(Map.of("message","File is uploaded and data is save to the database"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
	}
	
	@GetMapping ("/getun")
	public List<University> getAllun()
	{
		return this.ser.getAllun();
	}
}
