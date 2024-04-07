import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class Demo {

	public static boolean IsPrimeNumber(int num)
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
	
public static class testprime
{
	@Test
	void test()
	{
		assertTrue(IsPrimeNumber(2));
		assertTrue(IsPrimeNumber(3));
		assertTrue(IsPrimeNumber(5));
		assertTrue(IsPrimeNumber(7));
		
		
		assertFalse(IsPrimeNumber(1));
		assertFalse(IsPrimeNumber(4));
		assertFalse(IsPrimeNumber(6));
		assertFalse(IsPrimeNumber(8));
		assertFalse(IsPrimeNumber(10));
		
	}
}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the first number:-");
		int fNumber=sc.nextInt();
		
		System.out.println("Enter Last number :-");
		int lNumber=sc.nextInt();
		
		
		System.out.println("prime number start from" + fNumber +" to "+ lNumber );
		for(int i=Math.max(fNumber,2);i<=lNumber;i++)
		{
			if(IsPrimeNumber(i))
			{
				System.out.println(i);
			}
		}
	}
}
