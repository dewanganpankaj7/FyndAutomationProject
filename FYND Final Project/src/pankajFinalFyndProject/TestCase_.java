package pankajFinalFyndProject;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.write.WriteException;

public class TestCase_ extends Test_Base {
	Page_Objects_Elements poe; // creating object for the class Page_object_Elements to call the web elements.
	public TestCase_() {
		super();// This is used to call the constructor of parent class
	}
	@BeforeMethod
	public void setup() {// Test: Launch the web application i.e https://test-nf.com/english.html
		initialization();
		poe = new Page_Objects_Elements();
	}
	
	@Test
	public void elementisDisplayed() {
		poe.checkElements(); // Test 2: testing the availability of each tab(Home, football, busketball, kriket, cibersport)
		poe.URL();	        // Test 3: testing the url of each tab containing Tab Name.
		poe.writeUrltoexcel();// Test 4: Storing all the current URL into the excel sheet
	}
	
	
	
    @AfterMethod
    public void teardown() throws WriteException, IOException {// closing all the current windows and files
    	wb.close();
    	
    	driver.close();
    }
}
