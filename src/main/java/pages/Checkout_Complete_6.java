package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Complete_6 extends TestBase
{

	@FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement checkout_Complete_Title  ;
	@FindBy(xpath = "//img[@alt='Pony Express']") private WebElement image_Displayed  ;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement  thank_For_Order ;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement order_Dispatch_Message  ;
	@FindBy(xpath = "//button[@id='back-to-products']") private WebElement  backHome_Button ;
	
	//Constructor to initialize above WebElements
	public Checkout_Complete_6() {
		PageFactory.initElements(driver, this);
	}
		
		public String verify_checkout_Complete_Title  () {
			return  checkout_Complete_Title.getText();
			}
		
		public boolean verify_image_Displayed  () //Green Tick
		{
			return image_Displayed.isDisplayed() ;
		}
		
		public String verify_thank_For_Order  ()
		{
			return  thank_For_Order.getText();
		}
		
		public String verify_order_Dispatch_Message  ()
		{
			return order_Dispatch_Message.getText() ;
		}
		
		public String verify_backHome_Button  ()
		{
			backHome_Button.click();
			return driver.getCurrentUrl() ;
		}
	
}
