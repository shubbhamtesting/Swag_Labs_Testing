package utility;


import java.text.SimpleDateFormat;
import java.util.Date;

// ExtentReports -> report client for starting reporters and building reports. 
//For most applications,you should have one ExtentReports instance for the entire JVM. 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;
import freemarker.template.SimpleDate;

public class Extent_Report_Manager extends TestBase {

	//Create an object Globally
	static ExtentReports report;
	
	public static ExtentReports myGetReportInstance () {
		
		if (report == null)
		{
			String reportName= new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date() );
			ExtentHtmlReporter myHtmlReporter = new ExtentHtmlReporter("F:\\Eclipse\\Selenium_Framework_SSquare_IT\\Extent_Report\\report123.html");
			// ExtentHtmlReporter creates a -> HTML file. -> uses-> config() method.
			
			report = new ExtentReports();  //Object created
			report.attachReporter(myHtmlReporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Enviornment", "SIT");
			report.setSystemInfo("Biuld Number", "108.24.14.01");
			report.setSystemInfo("Browser", "Chrome");
			
			//Set Document Title
			myHtmlReporter.config().setDocumentTitle("Shubbham UI Testing Documents");
			myHtmlReporter.config().setReportName("Shubbham UI Test Report");
			
			//Now next what we do is -> refer this Extent Report to -> TestBase (package base;)
			
		}
			
		return report;
	}
}
