package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.hql.spi.id.cte.AbstractCteValuesListBulkIdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.Repositorystu;
import com.example.demo.serviceI.Services;
import com.example.demo.student.student;

@Service
public class Serviceimpl implements Services {

	@Autowired
	Repositorystu rst;
	
	@Override
	public student poststu(student s) {
	  return rst.save(s);
		
	}

	@Override
	public List<student> getstu() {
		return rst.findAll() ;
	}

	@Override
	public student updatestu(Integer sid, student s) {
		
		Optional<student> stu=rst.findBysid(sid);
		if(stu.isPresent())
		{
			student stu1=stu.get();
			stu1.setSname(s.getSname());
			stu1.setSaddr(s.getSaddr());
			stu1.setSmono(s.getSmono());
			
			return rst.save(stu1);
		}
		else {
			System.out.println("id not match"); 
		    return null;
			}
	}

	@Override
	public void deletestu(Integer sid) {
	  rst.deleteById(sid);
		
	}

}
