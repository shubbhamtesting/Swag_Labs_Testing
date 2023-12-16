package testCases;

import java.io.IOException;    



//We Never use main method for execution in Selenium Framework

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

//In Test Cases we use Annotations
//Annotations -> in TestNG are lines of codes that can control 
//         how  the below method will be executed. 
//Note- Annotations are always preceded by @ symbol.

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage_1;
import utility.Capture_Screenshoot;
import utility.ReadData_from_TestData;

public class Test_LoginPage_1 extends TestBase {

	LoginPage_1 myLogin; // we created the object of LoginPage_1 & also import its package
	
//11/12/2023-> We are performing Grouping For that we need to make -> @BeforeMethod & @AfterMethod -> (alwaysRun = true) -> must run No matter if Test- Fail/Pass

	@BeforeMethod (alwaysRun = true)
		public void setup() throws InterruptedException, IOException {
		initialization();
		myLogin = new LoginPage_1(); // to use Login Object we need to write method inside @BeforeMethod
	}

	//Day1
	@Test (groups = "Sanity Grp-1")
	public void verifyTitleofApplicationTest() {
		String expTitle = "Swag Labs";
		String actTitle = myLogin.verifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle); // expected = actual Title  Test Case  Pass
	}

	//Day1
	@Test (groups = {"Sanity Grp-1", "Retesting Grp-2"})
	public void verifyURLOfApplicationTest() {
		String expURL = "https://www.saucedemo.com/";
		String actURL = myLogin.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL); // expected = actual URL -> Test Case -> Pass
	}

//	//Day2
//	@Test (groups = "Regression Grp-3")
//	public void loginIntoApplicationTest() throws IOException
//	{
//		String expectedURL = "https://www.saucedemo.com/inventory.html";
//		String actualURL = myLogin.loginIntoApplication();
//		Assert.assertEquals(expectedURL, actualURL);
//	}

//-------------------------------------------------------------------------------------
//	//Day3
//		@Test
//		public void loginIntoApplicationTest() throws IOException
//		{
//			String expectedURL = "https://www.saucedemo.com/inventory.html";
//			String actualURL = myLogin.loginIntoApplication();
//			Assert.assertEquals(expectedURL, actualURL);
//		}

//-------------------------------------------------------------------------------------------
	
	// Day 5 (Video 7) (Its a copy of Day 2. But this time input is taken from Excel
	// Sheet. Earlier -> config.properties)
	
	//8/12/2023 -> priority; enabled ; dependsOnMethods
//	@Test (priority = 3, enabled=true, dependsOnMethods = "verifyURLOfApplicationTest")
//	public void verifyTitleofApplicationTest() throws IOException {
//		String expTitle = ReadData_from_TestData.readSwagLabsDataExcel(0, 0); // Swag Labs (0,0)
//		String actTitle = myLogin.verifyTitleofApplication();
//		Assert.assertEquals(expTitle, actTitle); // expected = actual Title  Test Case  Pass
//	}
//
//	// Day 5 (Its a copy of Day 1. But this time input is taken from Excel Sheet.)
//	@Test (priority = 2, enabled=true)
//	public void verifyURLOfApplicationTest() throws IOException {
//		String expURL = ReadData_from_TestData.readSwagLabsDataExcel(0, 1); // "https://www.saucedemo.com/" (0,1)
//		String actURL = myLogin.verifyURLOfApplication();
//		Assert.assertEquals(expURL, actURL); // expected = actual URL Test Case  Pass
//		Reporter.log("URL of Application is = " + actURL);
//	}
//
//	// Day 5 (1/12/23) (Its a copy of Day 2. But this time input is taken from Excel
//	// Sheet.)
//	@Test (priority = 3, enabled=true, dependsOnMethods = "verifyURLOfApplicationTest")
//	public void loginIntoApplicationTest() throws IOException {
//		String expectedURL = ReadData_from_TestData.readSwagLabsDataExcel(0, 2); // "https://www.saucedemo.com/inventory.html"
//																					// (0,2)
//		String actualURL = myLogin.loginIntoApplication();
//		Assert.assertEquals(expectedURL, actualURL);
//		Reporter.log("Login to Application = "+actualURL);
//	}

//-----------------------------------------------------------------------------------------
	// To capture the Screen-shoot we will make a forced error in just above code
	// Error is Index(0,2) -> changed to -> (0,9)

	// Day 6 (2/12/23) (Its a copy of Day 2. But this time input is taken from Excel
	// Sheet.)
//	@Test
//	public void screenshot_Error_loginIntoApplicationTest () throws IOException {
//		String expectedURL = ReadData_from_TestData.readSwagLabsDataExcel(0, 2); // ERROR
//		String actualURL = myLogin.loginIntoApplication();
//		Assert.assertEquals(expectedURL, actualURL);
//	}

//--------------------------------------------------------------------------
	// Normal After Method
//	  @AfterMethod public void closeBrowser() 
//	  {
//		  driver.close();
//	  }
//-------------------------------------------------------------------------
	
	@Test 
	public void test_login_to_Application_generate_ExtentReport() throws IOException
	{
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		String actualURL = myLogin.login_to_Application_generate_ExtentReport();
		Assert.assertEquals(expectedURL, actualURL);
	}

//----------------------------------------------------------------------------------------------
	
	
	// After Method with Screen-shoot
	// ITestResult -> taken from TestNG -> it is a kind of data-type
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult myIT) throws IOException {
		// Now if any of above test fails then capture its screenshot
		//if (myIT.FAILURE == myIT.getStatus()) 
		if (ITestResult.FAILURE == myIT.getStatus()) {
			// Call Screenshot method here
			Capture_Screenshoot.screenshot(myIT.getName()); // getName() -> will provide name of failed method
		}
		report.flush();
		driver.close();
	}
}


