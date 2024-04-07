package com.example.demo.Helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.University;

public class Helper {

	// first check the file is excel format or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
	  String contentType = file.getContentType();
	 
	  if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet "))
			  {
		        return true; 
			  }
	  else 
	        {
		       return false;
	        }
	}
	
	//convert excel to list of product
	//List ko read karenge
	public static List<University> convertExcelToListofUniversity(InputStream is)
	{
		List<University> list =new ArrayList<>();
		try {
		//sheet jo upload hoke ayei hai 	
		  XSSFWorkbook workbook	=new XSSFWorkbook(is);
		  XSSFSheet sheet=workbook.getSheet("data");
		 
		//work on single row
		  int rowNumber=0;
		 Iterator<Row> iterator=sheet.iterator();
		 while (iterator.hasNext()) {
		     Row row =iterator.next();
		 
		     //first row skip i.e. column name;
		     if(rowNumber==0)
		     {
		    	 rowNumber++;
		    	 continue;
		     }
		     
		   //take single single cell in one row
		    Iterator<Cell> cells=row.iterator();
		    int cid=0;
		    
		    University un=new University();
		    
		    while (cells.hasNext()) 
		    {
				Cell cell = cells.next();
				
				switch(cid)
				{
				  case 0:
				      un.setCId((int)cell.getNumericCellValue());
				      break;
				      
				  case 1:
					  un.setCName(cell.getStringCellValue());
				      break;
					  
				  case 2:
					  un.setCAddr(cell.getStringCellValue());
					  break;
					  
				  case 3:
					  un.setNBranch((int)cell.getNumericCellValue());
					  break;
					  
				  case 4:
					  un.setCMoNo((float)cell.getNumericCellValue());
					  break;
					
				  default:
					  break;
				}
				cid++;
			}
		    list.add(un);
			
		}
		 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
				
	}
}














