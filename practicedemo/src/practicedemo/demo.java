package practicedemo;

import java.util.ArrayList;
import java.util.List;

public class demo {

 private static  boolean isPrime(int num) 
  {
	     if(num<=1)
	      {
		    return false;
	      }
	     else
	      {
		     for(int i=2;i<=Math.sqrt(num);i++)
		       {
			     if(num%i==0)
			       {
				     return false;
			       }
		       }
	      }
	   return true;
  }

	
	
	public static void main(String[] args) {
		int start=1;
		int end=10;
		
			List<Integer> primeNumList=new ArrayList<>();
			for(int i=Math.max(start,2);i<=end;i++)
		      {
			    if(isPrime(i))
			    {
			    	primeNumList.add(i);
			    }
		      }
			System.out.println(primeNumList);

	}

}
