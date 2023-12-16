package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Day 3 & 5 
public class ReadData_from_TestData 
{

	//Day 3 (Video 5) (Read data from Config.properites - of - TestData folder)
	public static String readPropertyFile (String value) throws IOException 
	{
		Properties myProp = new Properties();  //get from java.util.properties
		                                       //Created an object of config.properties file
		
		//To read config.properties -> we set its path
		FileInputStream myFile = new FileInputStream("F:\\Eclipse\\Selenium_Framework_SSquare_IT\\TestData\\config.properties");
		
		myProp.load(myFile); //Reads a property list (key and element pairs) from the inputbyte stream. The input stream is in a simple line-orientedformat as specified in load(Reader) 
		return myProp.getProperty(value);  //This will return values from our TestData
	}
	
	//Day 5 (Video 7) (This ReadData from Swag Labs Excel file - of - TestData folder)
	//This time we will read Data in continuity. Earlier we did one by one.
	// here we declared two parameters -> int rowNum, int colNum
	
	public static String readSwagLabsDataExcel (int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		//FileInputStream & create -> both we need -> (File file) type (select accordingly)
		FileInputStream myFile = new FileInputStream("F:\\Eclipse\\Selenium_Framework_SSquare_IT\\TestData\\Swag Labs Data.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String myEachValue = mySheet.getRow(rowNum).getCell(colNum).getStringCellValue() ;
		
		return myEachValue;
		
	}
}
