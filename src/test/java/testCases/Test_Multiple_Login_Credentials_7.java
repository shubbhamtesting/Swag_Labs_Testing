package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Multiple_Login_Credentials_7;
import utility.Capture_Screenshoot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Test_Multiple_Login_Credentials_7 extends TestBase {

	Multiple_Login_Credentials_7 myMulti_Login_Cred;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		myMulti_Login_Cred = new Multiple_Login_Credentials_7();
	}

	@DataProvider(name =  "Multi Login Credentials")
	//We need to create an 2-d Array -> storing UserName & Password 
	//Array's data-type is Object class (Super class of all classes)
	//Method name for this DataProvider is -> my_Get_Data
	public Object [][] my_Get_Data ()
	{
		return new Object [][]
				{
//			{"standard_user","secret_sauce"},
//			{"locked_out_user","secret_sauce"},
//			{"problem_user","secret_sauce"},
//			{"performance_glitch_user","secret_sauce"},
//			{"error_user","secret_sauce"},
//			{"visual_user","secret_sauce"},
			
			//Test Cases for Login             Username  Password
			{"standard_user","secret_sauce"},// R         R
			{"standard_user","secret_sauce_W"},// R         W
			{"standard_user_W","secret_sauce"},// W         R
			{"standard_user_W","secret_sauce_W"},// W         W
		
		};
	}

	@Test(dataProvider = "Multi Login Credentials")
	public void test_login_with_Multi_Credentials(String myUserName, String myPassword) {
		
		//Since we do NOT want skipping -> as & when failure occurs -> Solution- SoftAssert
		SoftAssert sa = new SoftAssert();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		
    	String actualURL = myMulti_Login_Cred.login_with_Multi_Credentials(myUserName, myPassword);
		sa.assertEquals(actualURL, expectedURL);
    	sa.assertAll();
		Reporter.log("Login to Application = " + actualURL);		
	}
		
	@AfterMethod
	public void closeBrowser(ITestResult myIT) throws IOException {
		// Now if any of above test fails then capture its screenshot
		// if (myIT.FAILURE == myIT.getStatus())
		if (ITestResult.FAILURE == myIT.getStatus()) {
			// Call Screenshot method here
			Capture_Screenshoot.screenshot(myIT.getName()); // getName() -> will provide name of failed method
		}
		driver.close();
	}

}
