package testCases;

import org.testng.annotations.Test;

import base.TestBase;
import pages.Checkout_Your_Information_4;
import pages.Inventory_Page_2;
import pages.LoginPage_1;
import pages.Shopping_Cart_3;
import utility.Capture_Screenshoot;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Test_Checkout_Your_Information_4 extends TestBase {

	LoginPage_1 myLogin;
	Inventory_Page_2 myInventory;
	Shopping_Cart_3 myShoppingCart;
	Checkout_Your_Information_4 mycheckInfo;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		myLogin = new LoginPage_1();
		myLogin.loginIntoApplication();

		myInventory = new Inventory_Page_2();
		myInventory.navigate_to_Shopping_Cart();

		myShoppingCart = new Shopping_Cart_3();
		myShoppingCart.navigate_to_Checkout_Page();

		mycheckInfo = new Checkout_Your_Information_4();
	}

	@Test
	public void test_verify_Swag_Labs_Title() {
		String expectedTitle = "Swag Labs";
		String actualTitle = mycheckInfo.verify_Swag_Labs_Title();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("swag Labs Titles = " + actualTitle);
	}

	@Test
	public void test_verify_Checkout_Info_Title() {
		String expectedTitle = "Checkout: Your Information";
		String actualTitle = mycheckInfo.verify_Checkout_Info_Title();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Checkout Info title = " + actualTitle);
	}

	@Test
	public void test_verify_Entry_Tab() {
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actURL = mycheckInfo.verify_Entry_Tab();
		Assert.assertEquals(expURL, actURL); 
		Reporter.log ("Continue Button after click navigates to = " + actURL);
	}
	

	@Test
	public void test_verify_Cancel_Button() {
		String expURL = "https://www.saucedemo.com/inventory.html"; 
		String actURL = mycheckInfo.verify_Cancel_Button();
		Assert.assertEquals(expURL, actURL); 
		Reporter.log ("Cancel Button after click navigates to = " + actURL);
	}

	@Test
	public void test_verify_Continue_Button() {
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actURL = mycheckInfo.verify_Continue_Button();
		Assert.assertEquals(expURL, actURL); 
		Reporter.log ("Continue Button after click navigates to = " + actURL);
	}

	@Test
	public void test_verify_Cart_Icon() {
		boolean result = mycheckInfo.verify_Cart_Icon();
		Assert.assertEquals(result, true); // compares with return True
		Reporter.log("Cart Icon is it displayed = " + result);
	}

	@Test
	public void test_verify_Menu_Icon() {
		boolean result = mycheckInfo.verify_Menu_Icon();
		Assert.assertEquals(result, true); // compares with return True
		Reporter.log("Menu Icon is it displayed = " + result);
	}

//  @Test
//  public void test_() {
//  }

	@AfterMethod
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
