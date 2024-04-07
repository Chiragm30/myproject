package demo1;

import java.util.stream.Collectors;
import java.util.*;
import java.util.Map.Entry;


public class MyClass {
  public static void main(String[] args) 
  {
	 
	 String str="1,2,2";
	 String str1="";
	 for(int i=0;i<str.length();i++)
	 {
		 char c=str.charAt(i);
		 if(str.equals(c))
		 {
			 System.out.println("duplicate element:" +c);
		 }
		 else
		 {
			 str1=str+c;
		 }
	 }
	   System.out.println("unique element :- "+ str1);
  }
 
}
	      
	   
