package testCases;

import org.testng.annotations.Test;

import base.TestBase;
import pages.Checkout_Complete_6;
import pages.Checkout_Overview_5;
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

public class Test_Checkout_Complete_6 extends TestBase{
  
	LoginPage_1 myLogin;
	Inventory_Page_2 myInventory;
	Shopping_Cart_3 myShoppingCart;
	Checkout_Your_Information_4 mycheckInfo;
	Checkout_Overview_5 myCheckOverview;
	Checkout_Complete_6 myCheckoutComplete;
	

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
		mycheckInfo.navigate_to_Checkout_Overview_Page();

		myCheckOverview = new Checkout_Overview_5();
		myCheckOverview.navigate_to_Checkout_Complete();
		
		myCheckoutComplete = new Checkout_Complete_6();
	}
	
  
  @Test
  public void test_verify_checkout_Complete_Title () {
	  String expectedTitle = "Checkout: Complete!";
		String actualTitle = myCheckoutComplete.verify_checkout_Complete_Title();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Checkout Complete Title = " + actualTitle);
	}
  
  
  @Test
  public void test_verify_image_Displayed () {
	  boolean result = myCheckoutComplete.verify_image_Displayed();
	  Assert.assertEquals(result, true);
	  Reporter.log("Green Tick is Displayed = " +result);
  }
  
  @Test
  public void test_verify_thank_For_Order () {
	  String expectedTitle = "Thank you for your order!";
		String actualTitle = myCheckoutComplete.verify_thank_For_Order();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Display Thanks Message = " + actualTitle);
	}  
  
  
  @Test
  public void test_verify_order_Dispatch_Message () {
	  String expectedTitle = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actualTitle = myCheckoutComplete.verify_order_Dispatch_Message();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Order Dispatch Message = " + actualTitle);
	}
  
  
  @Test
  public void test_verify_backHome_Button () {
	  String expectedURL = "https://www.saucedemo.com/inventory.html";
		String actualURL = myCheckoutComplete.verify_backHome_Button();
		Assert.assertEquals(actualURL, expectedURL);
		Reporter.log("Finds out Swag Labs Title = " + actualURL);
	}
  
  
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
