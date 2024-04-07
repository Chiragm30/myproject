package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.helper.FileuploadHelper;

import antlr.debug.NewLineEvent;

@RestController
public class FileuploadController {

	@Autowired
	private FileuploadHelper fileuploadhelper;
	
	@PostMapping(value="upload-file")
	public ResponseEntity<String> uploadfile(@RequestParam("file")MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		
		try {
			boolean f=fileuploadhelper.uploadfile(file);
			if(f)
			{
				//return ResponseEntity.ok("file is successfully upload");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some went wrong  try again");    
	}
}
