package utility;

//This code will handle all the drop downs thorughout our application 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Handle_Dropdown_List 
{
     
	//public - accessible throughout application 
	//static -> can NOT be changed from outside
	//We need string element -> it stores name of the Drop-down
	//Also needed string value(option) -> it stores one specific element(option) from the drop-down; whom we will cross check
	
	public static void handleSelectClass (WebElement dropdownName , String dropdownValue)
	{
		Select sc = new Select(dropdownName);
		 sc.selectByVisibleText(dropdownValue); //Here I applied filter
	}
	
}
