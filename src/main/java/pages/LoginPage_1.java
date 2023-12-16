package pages;

import java.io.IOException; 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData_from_TestData;

public class LoginPage_1 extends TestBase {

	//Day2
	//Below is called as - 
	//Object Repository - here we store all our Web elements
	@FindBy(xpath = "//input[@name='user-name']") private WebElement myUserTextBox;
	@FindBy(xpath = "//input[@name='password']") private WebElement myPasswordTextBox;
	@FindBy(xpath = "//input[@name='login-button']") private WebElement myLoginButton;
	
	//Creating Constructor - used to initialize object/ Global variable
	//PageFactory - all elements of class initialize with driver using this keyword
	//It contain static	method	initElements :- to	initialize	data	member	
	//in page factory	we	need to use  initElements method in	constructor (Late or Lazy initialisation)
	
    public LoginPage_1()
    {
    	PageFactory.initElements(driver, this); //'this' will point to above WeElalments one by one when called in test class
    }

 //-----------------------------------------------------------------------------------------------------
	
  //12/12/2023 -> we are generating Extent Report
  	public String login_to_Application_generate_ExtentReport () throws IOException
  	{
  		myLogger= report.createTest("Login to Sauce Lab Application");
  		myUserTextBox.sendKeys("standard_user"); 
  		myLogger.log(Status.INFO,"User Name is entered");
  		myPasswordTextBox.sendKeys("secret_sauce");
  		myLogger.log(Status.INFO,"Password is entered"); 
  		myLoginButton.click();
  		myLogger.log(Status.INFO,"Login Button is clicked"); 
  		myLogger.log(Status.PASS,"Login is sucessful");
  		return driver.getCurrentUrl();	
  	}


//-------------------------------------------------------------------------------------------
  //Day 3
    //Since UserName, Password, Login Button are dependent on each other so written in 1 method only
    public String loginIntoApplication () throws IOException //as we are inserting data & getting its output 
    {
    	//reading from config.properties
    	myUserTextBox.sendKeys(ReadData_from_TestData.readPropertyFile("UserName")); //it is reading data from -> config.properties
    	myPasswordTextBox.sendKeys(ReadData_from_TestData.readPropertyFile("Password"));
    	
    	//reading from Excel
//    	myUserTextBox.sendKeys(ReadData_from_TestData.readSwagLabsDataExcel(0, 6));
//    	myPasswordTextBox.sendKeys(ReadData_from_TestData.readSwagLabsDataExcel(0, 7));
    	myLoginButton.click();
    	
    	//once login navigate to next page
    	//need that new web page URL -> "https://www.saucedemo.com/inventory.html"
    	return driver.getCurrentUrl();
    }
    
    //-------------------------------------------------------------------------------------------    
//  //Day2 
//    //Since UserName, Password, Login Button are dependent on each other so written in 1 method only
//    public String loginIntoApplication ()
//    {
//    	myUserTextBox.sendKeys("standard_user");
//    	myPasswordTextBox.sendKeys("secret_sauce");
//    	myLoginButton.click();
//    	
//    	//once login navigate to next page
//    	//need that new web page URL - "https://www.saucedemo.com/inventory.html"
//    	return driver.getCurrentUrl();
//    }

   //-------------------------------------------------------------------------------------------
	//Day 1
	public String verifyTitleofApplication()
	{
		return driver.getTitle();
	}
	
	//Day1
    public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
    
    
}


