package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Capture_Screenshoot extends TestBase
{
	//Select SimpleDateFormat(String pattern)
	//Select format(Date date)
	//Date() pre-defined class in java
	
     public static String get_Date_Time ()
     {
    	 return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
     }
     
     public static void screenshot(String nameOfMethod) throws IOException
     {
    	File sourceOfScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File destinationOfScreenshot = new File("F:\\Eclipse\\Selenium_Framework_SSquare_IT\\Screenshot\\" 
    			                                 + nameOfMethod + "  " + get_Date_Time() + ".jpeg");
    	                      //Mention extension -> ".jpeg" - in which I have to save the file 
     //F:\\Eclipse\\Selenium_Framework_SSquare_IT\\Screenshot <- actual path of Screenshot folder
    	
    	//Select FileHandler from Selenium
    	//copy(File from,File to)
    	FileHandler.copy(sourceOfScreenshot, destinationOfScreenshot);
     
     }
	
}
