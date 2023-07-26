package pankajFinalFyndProject;

import java.io.File;
import java.io.FileInputStream;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;




public class Test_Base {
	// Statically defining all the variables in the class level so that it can be used or utilized among its all child class
	
	public static WebDriver driver;
	public static Workbook wb;
	public static Sheet sh;
	public static WritableWorkbook wrwb;
	public static WritableSheet wrsh;
	
	
	

 public Test_Base() {// Constructor for providing the path for sheets to read and write from excel file by using jxl jar file
	
	 
	  try {
		  FileInputStream fi= new FileInputStream("C:\\Users\\Pankaj Dewangan\\Desktop\\project.xls");
		wb = Workbook.getWorkbook(fi);
		wrwb=Workbook.createWorkbook(new File("C:\\Users\\Pankaj Dewangan\\Desktop\\projectotpt.xls"));
		 

	} 
	  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	
	  sh = wb.getSheet("Sheet1");
	
	 }
	  // Reading data from excel file for system.set properties and also to launch the web application
	  public static void initialization()
	  {
		  System.setProperty(sh.getCell(0,0).getContents(), sh.getCell(1,0).getContents());
		      driver= new ChromeDriver();
			 driver.get(sh.getCell(0,1).getContents());
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 
	  }

 }


