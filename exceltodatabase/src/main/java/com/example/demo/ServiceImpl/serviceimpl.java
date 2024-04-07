package com.example.demo.ServiceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Helper.Helper;
import com.example.demo.Model.University;
import com.example.demo.repository.repository;

@Service
public class serviceimpl {
	
	@Autowired
	private repository unrepo;

	public void save(MultipartFile file)
	{
		try {
		     List<University> un=Helper.convertExcelToListofUniversity(file.getInputStream());
		    this.unrepo.saveAll(un);   
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<University> getAllun()
	{
		return this.unrepo.findAll();
	}
}
