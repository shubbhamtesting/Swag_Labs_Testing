package pages;
//Accepted usernames are: We will check each one of them 
//standard_user
//locked_out_user
//problem_user
//performance_glitch_user
//error_user
//visual_user

//Password for all users: secret_sauce


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Multiple_Login_Credentials_7 extends  TestBase{
	
	//Object Repository - here we store all our Web elements
		@FindBy(xpath = "//input[@name='user-name']") private WebElement myUserTextBox;
		@FindBy(xpath = "//input[@name='password']") private WebElement myPasswordTextBox;
		@FindBy(xpath = "//input[@name='login-button']") private WebElement myLoginButton;
		
		//Creating Constructor - used to initialize object/ Global variable
		//PageFactory - all elements of class initialize with driver using this keyword
		//It contain static	method	initElements :- to	initialize	data	member	
		//in page factory	we	need to use  initElements method in	constructor (Late or Lazy initialisation)
		
	    public Multiple_Login_Credentials_7 ()
	    {
	    	PageFactory.initElements(driver, this);	    }
		

	public String login_with_Multi_Credentials (String myUserName, String myPassword)  
    {
    	myUserTextBox.sendKeys(myUserName);
    	myPasswordTextBox.sendKeys(myPassword);
    	    	  	
    	myLoginButton.click();
    	
    	//once login navigate to next page Inventory -> "https://www.saucedemo.com/inventory.html"
    	return driver.getCurrentUrl();
    }
}
