package com.app.PrimeNumGeneratorServer.PrimeservImpl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.PrimeNumGeneratorServer.Entity.PrimeNumRequest;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNumResponse;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNum;
import com.app.PrimeNumGeneratorServer.PrimeRepo.primeRepository;
import com.app.PrimeNumGeneratorServer.seviceI.PrimeServiceI;

@Service
public class PservicesImpl implements PrimeServiceI
{

	@Autowired
	private primeRepository prepo;
	
	@Override
	public PrimeNumResponse CalculatePrimeNumber(PrimeNumRequest pRequest) 
	{
		int start =pRequest.getFirstNumber();
		int end=pRequest.getLastNumber();
		
		long startTime = System.currentTimeMillis(); 
		List<Integer> primeNumList=new ArrayList<>();
		int count=0;
		
		//Logic to calculate prime Number
		for(int i=Math.max(start,2);i<=end;i++)
	      {
		    if(isPrime(i))
		    {   primeNumList.add(i);
		    	count++;
		    }
		  }
	
		
		
		//toCheck startTime print or not
		//System.out.println("start time :-"+startTime);
		//toCheckEndTime is print or not
		//System.out.println("end time :-" +endTime);
		//System.out.println("elapseTime is :-" +elapseTime);
		
		long endTime = System.currentTimeMillis();
		
		
		//calculate elapsedTime
		long elapseTime = endTime - startTime;
		
		
		//save data into Database for future Purpose
		PrimeNum saveData=new PrimeNum()
				.builder()
				.firstNumber(start)
				.lastNumber(end)
				.primeCount(count)
				.primeNumber(primeNumList)
				.elapsedTime(elapseTime)
				.timeStamp(new Timestamp(System.currentTimeMillis()))
				.build();
		 
		//set and get data into response Entity
		PrimeNumResponse prm=new PrimeNumResponse()
				.builder()
				.primeNumber(saveData.getPrimeNumber())
				.elapsedTime(saveData.getElapsedTime())
				.build();
				
				
			prepo.save(saveData);
		
		
	  return prm;
  }
	
	
	private static boolean isPrime(int num) 
    {
	    if(num<=1){return false;}
	    else
	        {
		       for(int i=2;i<=Math.sqrt(num);i++)
		       {  if(num%i==0){return false; }}
	        }
	   return true;
    }
}













