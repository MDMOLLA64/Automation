package com.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataProvider {

	
  @DataProvider(name="login")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @Test
  public void readTxtFile() throws IOException {
	 
	  FileReader f = null;
	  BufferedReader bf = null;
	  StringBuffer sb;
	  
	  try {
		  System.exit(1);
		   f=new FileReader(new File("/Users/bittech/Desktop/GitRemoteRepo/TestNGProject/read1.txt"));
		   bf=new BufferedReader(f);
		   String line=bf.readLine();
		   sb=new StringBuffer();
		  while(line!=null)
		  {
			  sb.append(line).append(System.lineSeparator());
			  line=bf.readLine();
		  }
		  System.out.println(sb);
		   
	  }catch(FileNotFoundException e)
	  {
//		  e.getMessage();
//		  e.printStackTrace();
		  System.out.println("file not found");
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		 System.out.println("io exception");
	}finally {
		if(f!=null)
		{
		f.close();
		}
		if(bf!=null)
		{
		bf.close();
		}
	}
	  System.out.println("continue");
  }
  
  
  WebDriver dr;
  
  @Test(dataProvider="login")
  public void test1(Object o,Object o1) {
	  dr.findElement(By.id("")).sendKeys(o.toString());
	  dr.findElement(By.id("")).sendKeys(o1.toString());
  }
  @DataProvider(name="login")
  public Object[][] readXL() {
	  FileInputStream f=null;
	  Object[][] data = null;
	  try {
		 f=new FileInputStream(new File("/Users/bittech/Desktop/GitRemoteRepo/TestNGProject/login.xlsx"));
	     XSSFWorkbook book=new XSSFWorkbook(f); 
	     XSSFSheet sheet=book.getSheetAt(0);
	    // XSSFCell cel=sheet.getRow(1).getCell(0);
	    // String v=cel.getStringCellValue();
	    
	     int rn=sheet.getLastRowNum();
	     int cn=sheet.getRow(0).getLastCellNum();
	      data=new Object[rn][cn];
	     for(int i=1;i<rn;i++)
	     {
	    	 for(int j=0;j<cn;j++)
	    	 {
	    		 XSSFCell cel=sheet.getRow(i).getCell(j); 
	    		 switch(cel.getCellType())
	    		 {
	    		 case XSSFCell.CELL_TYPE_NUMERIC:
	    		 {
	    			 //System.out.println(cel.getNumericCellValue());
	    			 data[i-1][j]=cel.getNumericCellValue();
	    		 }
	    		 case XSSFCell.CELL_TYPE_STRING:
	    		 {
	    			 //System.out.println(cel.getStringCellValue());
	    			 data[i-1][j]=cel.getStringCellValue();
	    		 }
	    		 }
	    	 }
	     }
	     
	  } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
	  
//	 return data; 
  }
  
  
  
  
  
  
  
}
