package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class University {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer cId;
	private String cName;
	private String cAddr;
	private int nBranch;
	private float cMoNo;

	
}
