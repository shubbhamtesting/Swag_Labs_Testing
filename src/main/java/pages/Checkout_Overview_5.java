package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Overview_5 extends TestBase {

//Xpath of all the Texts (Titles)
@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement swag_Labs_Title ;
@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkout_Overview_Title ;
@FindBy(xpath = "//div[text()='QTY']") private WebElement qyt_Lable ;
@FindBy(xpath = "//div[text()='Description']") private WebElement description_Label ;

//Xapth of all the payment info at the bottom
@FindBy(xpath = "//div[text()='Payment Information']") private WebElement payment_Information ;
@FindBy(xpath = "//div[text()='SauceCard #31337']") private WebElement sauceCard ;
@FindBy(xpath = "//div[text()='Shipping Information']") private WebElement shipping_Information ;
@FindBy(xpath = "//div[text()='Free Pony Express Delivery!']") private WebElement free_Pony_Express_Delivery ;
@FindBy(xpath = "//div[text()='Price Total']") private WebElement price_Total ;
@FindBy(xpath = "//div[text()='Item total: $']") private WebElement item_Total ;
@FindBy(xpath = "//div[text()='Tax: $']") private WebElement tax ;
@FindBy(xpath = "//div[text()='Total: $']") private WebElement total ;
@FindBy(xpath = "//div[contains(@class,'summary_info_label summary_total_label')]") private WebElement total_Using_Contains ;


//Xpath of 2 buttons at the end
@FindBy(xpath = "//button[@id='cancel']") private WebElement cancel_Button  ;
@FindBy(xpath = "//button[@id='finish']") private WebElement  finish_Button ;

//Constructor to initialize above WebElements
	public Checkout_Overview_5() {
		PageFactory.initElements(driver, this);
	}
		
		public String verify_swag_Labs_Title  () {
			return  swag_Labs_Title.getText();
			}
		
		public String verify_checkout_Overview_Title  () {
			return checkout_Overview_Title.getText();
		}
		
		public String  verify_qyt_Lable () {
			return  qyt_Lable.getText() ;
		}
		
		public String verify_description_Label  () {
			return  description_Label.getText() ;
		}
		
		public String verify_payment_Information  () {
			return payment_Information.getText()  ;
		}
		
		public String  verify_sauceCard () {
			return sauceCard.getText()  ;
		}
		
		public String verify_shipping_Information  () {
			return  shipping_Information.getText() ;
		}
		
		public String verify_free_Pony_Express_Delivery  () {
			return free_Pony_Express_Delivery.getText()  ;
		}
		
		public String verify_price_Total  () {
			return price_Total.getText()  ;
		}
		
		public String verify_item_Total  () {
			return  item_Total.getText() ;
		}
		
		public String verify_Tax  () {
			return tax.getText()  ;
		}
		
		public String verify_Total  () {
			return  total.getText() ;
		}
		
		public boolean verify_Total_by_Contains  () {
			return  total_Using_Contains.isDisplayed() ;
		}
		
		public String verify_cancel_Button  () {
			cancel_Button.click();
			return  driver.getCurrentUrl() ;
		}
		
		public String verify_finish_Button  () {
			finish_Button.click();
			return driver.getCurrentUrl()  ;
		}
		
		public String navigate_to_Checkout_Complete  () {
			finish_Button.click();
			return driver.getCurrentUrl()  ;
		}
	}

