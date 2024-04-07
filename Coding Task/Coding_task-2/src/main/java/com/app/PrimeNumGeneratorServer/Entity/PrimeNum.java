package com.app.PrimeNumGeneratorServer.Entity;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PrimeNum {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Timestamp timeStamp;
	private int firstNumber;
	private int lastNumber;
	private int primeCount;
	private long elapsedTime;
	
	@ElementCollection
	private  List<Integer> primeNumber;
	
}
