package testCases;
//All the test cases for Inventory page  methods will be written here

import org.testng.annotations.Test;     

import base.TestBase;
import pages.Inventory_Page_2;
import pages.LoginPage_1;
import utility.Capture_Screenshoot;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Test_Inventory_Page_2 extends TestBase {

	LoginPage_1 myLogin;
	Inventory_Page_2 myInventory; // created Global Object of Inventory class (make it accessible throughout this
									// Test class)

	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException {
		initialization();
		myLogin = new LoginPage_1();
		myLogin.loginIntoApplication();
		myInventory = new Inventory_Page_2();
	}

	//Day 3
	@Test (priority = 1, enabled=true, groups = "Sanity Grp-1")
	public void test_verifyproductsLabel() 
	{
		String expectedLable = "Products";
		String actualLebel = myInventory.verifyproductsLabel();
		Assert.assertEquals(expectedLable, actualLebel);
		Reporter.log("Label of Inventory Page = " + actualLebel); 
		//Report (Provided by TestNG) = used to generate report of any text found on the application
	}

	//Day 3
	@Test (priority = 2, enabled=true, groups = {"Sanity Grp-1", "Retesting Grp-2"})
	public void test_verifytwitterLogo() {
		boolean result = myInventory.verifytwitterLogo();
		Assert.assertEquals(result, true);  //compares with return True
		Reporter.log("Visibilty of Twitter Logo = " + result);
	}
	
	//Day 3
	@Test (priority = 3, enabled=true, groups = "Regression Grp-3")
	public void test_verifyfacebookLogo () {
		boolean result = myInventory.verifyfacebookLogo();
		Assert.assertEquals(result, true);  //compares with return True
		Reporter.log("Visibilty of Facebook Logo = " + result);
	}
	
//	//Day 3
//	@Test (priority = 4, enabled=true)
//	public void test_verifylinkedinLogo () {
//		boolean result = myInventory.verifylinkedinLogo();
//		Assert.assertEquals(result, true);  //compares with return True
//		Reporter.log("Visibility of LinkedIn Logo = " + result);
//	}
//	
//	//Day 3 -> verifyswagLabFooterNote_by -> getText Method
//	@Test (priority = 5, enabled=true)
//	public void test_isDisplayed_VerifySwagLabFooterNote () {
//		String expectedFooterNote = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
//		String actualFooterNote = myInventory.verifyswagLabFooterNote_by_getText();
//		Assert.assertEquals(expectedFooterNote, actualFooterNote);
//		Reporter.log("Footer Note = " + actualFooterNote); 
//	}
//
//	//Day 3 -> verifyswagLabFooterNote_by -> using isDisplayed Method
//	@Test (priority = 6, enabled=true)
//	public void test_getText_VerifySwagLabFooterNote () {
//		boolean result = myInventory.verifyswagLabFooterNote_by_isDisplayed();
//		Assert.assertEquals(result, true);  //compares with return True
//		Reporter.log("Visibilty of Footer note = " + result);
//	}
	
	
//------------------------------------------------------------
//	//Day 4
//	@Test
//	public void test_add6Products ()  {
//		String expectedCount = "6";     //Try to store all values in String
//		String actualCount = myInventory.add6Products(); //add6Products giving me Count of 6 products I have added
//		Assert.assertEquals(expectedCount, actualCount);
//		Reporter.log("Total products added to cart = "+actualCount);
//	}

//	//Day 4
//	@Test
//	public void test_remove_2_Products () //6-2 = 4
//	{
//		String expectedCount = "4";     //Try to store all values in String
//		String actualCount = myInventory.remove_2_Products(); //add6Products giving me Count of 6 products I have added
//		Assert.assertEquals(expectedCount, actualCount);
//		Reporter.log("Total products removed to cart = "+actualCount);
//	}

//	// Day 5 (Its a copy of Day 3. But this time input is taken from Excel Sheet.)
//	@Test
//	public void test_verifyproductsLabel() throws EncryptedDocumentException, IOException {
//		String expectedLable = ReadData_from_TestData.readSwagLabsDataExcel(0, 3); // Products (0,3)
//		String actualLebel = myInventory.verifyproductsLabel();
//		Assert.assertEquals(expectedLable, actualLebel);
//		Reporter.log("Label of Inventory Page = " + actualLebel);
//		// Report (Provided by TestNG) = used to generate report of any text found on
//		// the application
//	}
//
//	// Day 5 (It's a Day 4 code. But expectedCount = "6" -> 6 value is taken from
//	// Excel)
//	@Test
//	public void test_add6Products() throws EncryptedDocumentException, IOException {
//		String expectedCount = ReadData_from_TestData.readSwagLabsDataExcel(0, 4); // 6 (0,4)
//		String actualCount = myInventory.add6Products();
//		Assert.assertEquals(expectedCount, actualCount);
//		Reporter.log("Total products added to cart = " + actualCount);
//	}
//
//	// Day 5 (It's a Day 4 code. But expectedCount = "4" -> 4 value is taken from
//	// Excel)
//	@Test
//	public void test_remove_2_Products() throws EncryptedDocumentException, IOException // 6-2 = 4
//	{
//		String expectedCount = ReadData_from_TestData.readSwagLabsDataExcel(0, 5); // 4 (0,5)
//		String actualCount = myInventory.remove_2_Products();
//		Assert.assertEquals(expectedCount, actualCount);
//		Reporter.log("Total products removed to cart = " + actualCount);
//	}
	
//  Normal After Method without Screenshot Code
//	@AfterMethod
//	public void closeBrowser() {
//		driver.close();
//	}

// --------------------------------------------------------------------------------------
//	// Day 6 (Here we made forced Error in day 5 code changing (0,5) to (0,7)
//	@Test
//	public void screenshoot_Error_test_remove_2_Products() throws EncryptedDocumentException, IOException // 6-2 = 4
//	{
//		String expectedCount = ReadData_from_TestData.readSwagLabsDataExcel(0, 5); // 4 (0,5) -> Error (0,7)
//		String actualCount = myInventory.remove_2_Products();
//		Assert.assertEquals(expectedCount, actualCount);
//		Reporter.log("Total products removed to cart = " + actualCount);
//	}

	// Day 6 (Video 8)
	// After Method with Screen-shoot
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult myIT) throws IOException {
		// Now if any of above test fails then capture its screenshot
		//if (myIT.FAILURE == myIT.getStatus()) 
		if (ITestResult.FAILURE == myIT.getStatus()) {
			// Call Screenshot method here
			Capture_Screenshoot.screenshot(myIT.getName()); // getName() -> will provide name of failed method
		}
		driver.close();
	}

}

