package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.University;
import com.example.demo.UServiceI.UServices;


@RestController
@RequestMapping("/uapi")
public class ucontroller {
	
	@Autowired
	UServices usr;
	
	@PostMapping(value="upost")
	public University upost(@RequestBody University u)
	{
	    	   University unr=usr.upost(u);
	    	   return unr;
	}
	
	@GetMapping(value="uget")
	public List<University> UgetList()
	{
		  List<University> ulist=usr.UgetList();
		  return ulist;
	}
	
	@PutMapping(value="Uupdate/{uid}")
	public University Uupdate(@PathVariable("uid") Integer uid ,@RequestBody University u )
	{
		    u.setUid(uid);
		      University un=usr.Uupdate(uid,u);
		      return un;
	}
	
	@DeleteMapping(value="Udelete/{uid}")
	public String Udelete(@PathVariable("uid") Integer uid)
	{
		usr.Udelete(uid);
		return "Delete successfully";
	}

}
