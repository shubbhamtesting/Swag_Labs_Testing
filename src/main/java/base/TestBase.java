package base;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Extent_Report_Manager;
import utility.ReadData_from_TestData;

public class TestBase {

	//12/12/2023 -> we are generating Extent Report
	//Why we are writing it in TestBase -> b'coz TestBase is extended to all other class -> Wherever
	//I want to generate Extent report by Writing it in TestBase I can access it to all the classes 
	
	public ExtentReports report = Extent_Report_Manager.myGetReportInstance();
	
	//ExtentTest class -> Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
	//create an object of inbuilt ExtentTest class 
	
	public ExtentTest myLogger;      
	
	
//---------------------------------------------------------------------------------------------------------------
	//Day3 ->for Parallel Testing/ Compatibility across browser
	public static WebDriver driver; //WebDriver because we want to access all the drivers
	
	public void initialization () throws InterruptedException, IOException
	{
		String myBrowser = ReadData_from_TestData.readPropertyFile("Browser"); 
		//equated local var. myBrowser to ReadData class and its method inside it pass the value= "Browser"
		
		//For 3 browser need 3 if-else
		if (myBrowser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(myBrowser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver();
		}
		else if(myBrowser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//driver.manage().window().maximize();
		driver.get(ReadData_from_TestData.readPropertyFile("URL"));
		driver.manage().deleteAllCookies();
	}
	
	
//	//Day 1
//	public static ChromeDriver driver;
//	
//	public void initialization()
//	{
//		WebDriverManager.chromedriver().setup(); //it will setup ChromeDriver through WenbDriver Manager
//		driver = new ChromeDriver(); //up-casting
//		//driver.manage().window().maximize();
//		driver.get("https://www.saucedemo.com/");
//		
//		//Thread.sleep(3000); // usually we use Wait; Sleep is NOT used
//		//driver.close();
//	}
}
