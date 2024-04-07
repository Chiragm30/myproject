package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String caddr;
	private int Nbranch;
	private int cmono;

// bidirection onetoone mapping, this is child class hence we want to back parent class 
// by using jsonbackreference
	//jahase aye vahi vaps gye
	@OneToOne(mappedBy = "college")
	@JsonBackReference
	private University university;

	
}
