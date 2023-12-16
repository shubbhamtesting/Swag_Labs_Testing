package testCases;

import org.testng.annotations.Test;

import base.TestBase;
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

public class Test_Checkout_Overview_5 extends TestBase {

	LoginPage_1 myLogin;
	Inventory_Page_2 myInventory;
	Shopping_Cart_3 myShoppingCart;
	Checkout_Your_Information_4 mycheckInfo;
	Checkout_Overview_5 myCheckOverview;

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
	}

	@Test
	public void test_verify_swag_Labs_Title() {
		String expectedTitle = "Swag Labs";
		String actualTitle = myCheckOverview.verify_swag_Labs_Title();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Swag Labs Title = " + actualTitle);
	}

	@Test
	public void test_verify_checkout_Overview_Title() throws InterruptedException {
		String expectedTitle = "Checkout: Overview";
		Thread.sleep(7000);
		String actualTitle = myCheckOverview.verify_checkout_Overview_Title();
		Thread.sleep(7000);
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Checkout Overview Title = " + actualTitle);
	}

	@Test
	public void test_verify_qyt_Lable() {
		String expectedTitle = "QTY";
		String actualTitle = myCheckOverview.verify_qyt_Lable();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out QTY label = " + actualTitle);
	}

	@Test
	public void test_verify_description_Label() {
		String expectedTitle = "Description";
		String actualTitle = myCheckOverview.verify_description_Label();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Description label = " + actualTitle);
	}

	@Test
	public void test_verify_payment_Information() {
		String expectedTitle = "Payment Information";
		String actualTitle = myCheckOverview.verify_payment_Information();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Payment Info = " + actualTitle);
	}

	@Test
	public void test_verify_sauceCard() {
		String expectedTitle = "SauceCard #31337";
		String actualTitle = myCheckOverview.verify_sauceCard();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out SauceCard = " + actualTitle);
	}

	@Test
	public void test_verify_shipping_Information() {
		String expectedTitle = "Shipping Information";
		String actualTitle = myCheckOverview.verify_shipping_Information();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Shipping Info = " + actualTitle);
	}

	@Test
	public void test_verify_free_Pony_Express_Delivery() {
		String expectedTitle = "Free Pony Express Delivery!";
		String actualTitle = myCheckOverview.verify_free_Pony_Express_Delivery();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Who's delivering = " + actualTitle);
	}

	@Test
	public void test_verify_price_Total() {
		String expectedTitle = "Price Total";
		String actualTitle = myCheckOverview.verify_price_Total();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log(" what's Total Price = " + actualTitle);
	}

	@Test
	public void test_verify_item_Total() {
		String expectedTitle = "Item total: $29.99";
		String actualTitle = myCheckOverview.verify_item_Total();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Item total = " + actualTitle);
	}

	@Test
	public void test_verify_Tax() {
		String expectedTitle = "Tax: $2.40";
		String actualTitle = myCheckOverview.verify_Tax();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Tax = " + actualTitle);
	}

	@Test
	public void test_verify_Total() {
		String expectedTitle = "Total: $32.39";
		String actualTitle = myCheckOverview.verify_Total();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Finds out Total = " + actualTitle);
	}
	
	@Test
	public void test_verify_Total_by_Contains () {
		//String expectedTitle = "Total: $32.39";
		boolean result = myCheckOverview.verify_Total_by_Contains();
		Assert.assertEquals(result, true);
		Reporter.log("Finds out Total = " + result);
	}

	@Test
	public void test_verify_cancel_Button() {
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		String actualURL = myCheckOverview.verify_cancel_Button();
		Assert.assertEquals(actualURL, expectedURL);
		Reporter.log("Navigate back to Inventory Page = " + actualURL);
	}

	@Test
	public void test_verify_finish_Button() {
		String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
		String actualURL = myCheckOverview.verify_finish_Button();
		Assert.assertEquals(actualURL, expectedURL);
		Reporter.log("Go to Finish Page = " + actualURL);
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
