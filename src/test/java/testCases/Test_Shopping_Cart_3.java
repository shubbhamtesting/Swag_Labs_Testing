package testCases;

import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page_2;
import pages.LoginPage_1;
import pages.Shopping_Cart_3;
//import utility.Capture_Screenshoot;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Test_Shopping_Cart_3 extends TestBase {

	LoginPage_1 myLogin;
	Inventory_Page_2 myInventory;
	Shopping_Cart_3 myShoppingCart;
	
//11/12/2023 We are performing Grouping For that we need to make -> @BeforeMethod & @AfterMethod -> (alwaysRun = true) -> must run No matter if Test- Fail/Pass
	
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException {
		initialization();
		myLogin = new LoginPage_1();
		myLogin.loginIntoApplication();
		
		myInventory = new Inventory_Page_2();
		//myInventory.add6Products();
		myInventory.navigate_to_Shopping_Cart();

		myShoppingCart = new Shopping_Cart_3();
	}

//	@Test
//	public void test_verify_Shopping_Cart_Icon() {
//
//		String expectedCount = "3";     //Try to store all values in String
//		String actualCount = myShoppingCart.remove_3_Products(); //add6Products giving me Count of 6 products I have added
//		Assert.assertEquals(expectedCount, actualCount);
//		Reporter.log("Total products removed to cart = "+actualCount);
//	}
//
	@Test (priority = 1, enabled=true, groups = "Sanity Grp-1")
	public void test_verify_cart_Quantity_Label() {
		String expectedLable = "QTY";
		String actualLebel = myShoppingCart.verify_cart_Quantity_Label();
		Assert.assertEquals(expectedLable, actualLebel);
		Reporter.log("Label of Cart Quantity = " + actualLebel);
		// Report (Provided by TestNG) = used to generate report of any text found on
		// the application
	}

	@Test (priority = 2, enabled=true, groups = {"Sanity Grp-1", "Retesting Grp-2"})
	public void test_verify_Your_Cart_Label() {
		String expectedLable = "Your Cart";
		String actualLebel = myShoppingCart.verify_Your_Cart_Label();
		Assert.assertEquals(expectedLable, actualLebel);
		Reporter.log("Your Cart Label at Top = " + actualLebel);
	}

//	@Test (priority = 3, enabled=true)
//	public void test_verify_Open_Menu_Clickable() throws InterruptedException {
//		String expected_text_Option = "All Items";
//		//Thread.sleep(5000);
//		String actual_text_Option = myShoppingCart.verify_Open_Menu_Clickable();
//		//Thread.sleep(5000);
//		Assert.assertEquals(expected_text_Option, actual_text_Option);
//		Reporter.log("Open Menu and Look for 1st option = " + actual_text_Option);
//	}
//	
//	
//	@Test
//	public void test_verify_Open_Menu_Clickable_again_click () throws InterruptedException {
//		String expURL = "https://www.saucedemo.com/inventory.html";
//		//Thread.sleep(5000);
//		String actURL = myShoppingCart.verify_Open_Menu_Click_againclick_All_Items_Navigate();
//		//Thread.sleep(5000);
//		Assert.assertEquals(actURL, expURL);
//	}
//	
//
//	@Test
//	public void test_verify_twitterLogo() {
//		boolean result = myShoppingCart.verify_twitterLogo();
//		Assert.assertEquals(result, true); // compares with return True
//		Reporter.log("Visibilty of Twitter Logo = " + result);
//	}
//
//	@Test
//	public void test_verify_facebookLogo() {
//		boolean result = myShoppingCart.verify_facebookLogo();
//		Assert.assertEquals(result, true); // compares with return True
//		Reporter.log("Visibilty of Facebook Logo = " + result);
//	}
//
//	@Test
//	public void test_verify_linkedinLogo() {
//		boolean result = myShoppingCart.verify_linkedinLogo();
//		Assert.assertEquals(result, true); // compares with return True
//		Reporter.log("Visibilty of LinkedIn Logo = " + result);
//	}
//
//	@Test
//	public void test_verify_swagLabFooterNote_by_isDisplayed() {
//		boolean result = myShoppingCart.verify_swagLabFooterNote_by_isDisplayed();
//		Assert.assertEquals(result, true); // compares with return True
//		Reporter.log("Visibilty of Footer Note = " + result);
//	}
//
//	@Test
//	public void test_verify_continue_shoppingButton() {
//		String expURL = "https://www.saucedemo.com/inventory.html";
//		String actURL = myShoppingCart.verify_continue_shoppingButton();
//		Assert.assertEquals(expURL, actURL); // expected = actual URL -> Test Case -> Pass
//		Reporter.log ("Continue Button will redirect back to Inventory Webpage = " + actURL);
//	}
//
//	@Test
//	public void test_verify_checkoutButton() {
//		String expURL = "https://www.saucedemo.com/checkout-step-one.html";
//		String actURL = myShoppingCart.verify_checkoutButton();
//		Assert.assertEquals(expURL, actURL); // expected = actual URL -> Test Case -> Pass
//		Reporter.log ("Checkout Button will redirect to Checkout Webpage = " + actURL);
//	}
//	
//	//Verifying Back Pack Product Details - 1) Name of Product 2) Description 3) Price
//	
//	@Test
//	public void test_verify_BackPack_Product_Name ()
//	{
//		String expectedLable = "Sauce Labs Backpack";
//		String actualLebel = myShoppingCart.verify_BackPack_Product_Name();
//		Assert.assertEquals(expectedLable, actualLebel);
//		Reporter.log("Product name of Back Pack = " + actualLebel);
//	}
//	
//	@Test
//	public void test_verify_BackPack_Product_CLick_Redirecting ()
//	{
//		String expURL = "https://www.saucedemo.com/inventory-item.html?id=4";
//		String actURL = myShoppingCart.verify_BackPack_Product_CLick_Redirecting();
//		Assert.assertEquals(expURL, actURL); 
//		Reporter.log("Redirect to Back Pack product page = " + actURL);
//	}
//	
//	@Test
//	public void test_verify_BackPack_Product_Description ()
//	{
//		String expectedLable = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
//		String actualLebel = myShoppingCart.verify_BackPack_Product_Description();
//		Assert.assertEquals(expectedLable, actualLebel);
//		Reporter.log("Description of Back Pack = " + actualLebel);
//	}

//--------------------------------------------------------------------------------------------
	//Error $
//	@Test
//	public void test_verify_BackPack_Price ()
//	{
//		String expectedLable = "$29.99";
//		String actualLebel = myShoppingCart.verify_BackPack_Price();
//		Assert.assertEquals(expectedLable, actualLebel);
//		Reporter.log("Price of Back Pack = " + actualLebel);
////		boolean result = myShoppingCart.verify_BackPack_Price();
////		Assert.assertEquals(result, true);
////		Reporter.log("Price of Back Pack = " + result);
//	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult myIT) throws IOException {
		// Now if any of above test fails then capture its screenshot
		// if (myIT.FAILURE == myIT.getStatus())
		//if (ITestResult.FAILURE == myIT.getStatus()) {
			// Call Screenshot method here
			//Capture_Screenshoot.screenshot(myIT.getName()); // getName() -> will provide name of failed method
		//}
		driver.close();
	}

}
