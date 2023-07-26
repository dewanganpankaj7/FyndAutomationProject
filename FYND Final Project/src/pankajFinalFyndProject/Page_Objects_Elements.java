package pankajFinalFyndProject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

// Initializing Webelements value by using linktext locataors of each link tab
public class Page_Objects_Elements extends Test_Base{

	@FindBy(linkText ="Home") WebElement Home;

	@FindBy(linkText ="Football") WebElement Football;

	@FindBy(linkText ="Busketball") WebElement Busketball;

	@FindBy(linkText ="Kriket") WebElement Kriket;

	@FindBy(linkText ="Cibersport") WebElement Cibersport;

	// Constructor is used to initialize the value of web elements
	public Page_Objects_Elements() {

		PageFactory.initElements(driver, this);

	}
	//Test 2: Verify the availability of each tab(Home, Football, busketball, kriket, cibersports)
	public void checkElements() {
		boolean a= isDisplayed(Home);
		assertEquals(a, true);

		boolean b= isDisplayed(Football);
		assertEquals(b, true);

		boolean c= isDisplayed(Busketball);
		assertEquals(c, true);

		boolean d= isDisplayed(Kriket);
		assertEquals(d, true);

		boolean e= isDisplayed(Cibersport);
		assertEquals(e, true);

	}

	public boolean isDisplayed(WebElement element) {
		boolean value=element.isDisplayed();
		return value;
	}
	// Test 3: Verifying the Url contains the Tab name
	public void URL() {
		boolean a = getURL(Home);
		assertEquals(a, false);

		boolean b = getURL(Football);
		assertEquals(b, true);

		boolean c = getURL(Busketball);
		assertEquals(c, true);

		boolean d = getURL(Kriket);
		assertEquals(d, true);

		boolean e = getURL(Cibersport);
		assertEquals(e, true);
	}

	public boolean getURL(WebElement element) {

		String elementURL=element.getAttribute("href");

		String elementText=element.getText().toLowerCase();

		boolean present=elementURL.contains(elementText);
		return present;
	}

	public String getUrlForExcel(WebElement element) {
		String elementURL=element.getAttribute("href");
		return elementURL;
	}


	//Test 4: Storing all the values in Excel sheet
	public void writeUrltoexcel() {
		String arr[]=new String[5];
		arr[0]=getUrlForExcel(Home);
		arr[1]=getUrlForExcel(Football);
		arr[2]=getUrlForExcel(Busketball);
		arr[3]=getUrlForExcel(Kriket);
		arr[4]=getUrlForExcel(Cibersport);

		wrsh=wrwb.createSheet("TestSheet", 0);
		for(int i=0; i<arr.length;i++) {
			Label l = new Label(0, i, arr[i]);

			try {
				wrsh.addCell(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				wrwb.write();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}









