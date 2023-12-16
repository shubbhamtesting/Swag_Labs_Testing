package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

//Checkout tile 
//Three entry Tabs First name; Last name; Pin code
//Cancel button
//Continue button
//Method to Navigate to Checkout-Overview (Payment Page)

public class Checkout_Your_Information_4 extends TestBase {

	// Title xpath
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	private WebElement checkout_Info_Title;
	@FindBy(xpath = "//div[text()='Swag Labs']")
	private WebElement swag_Labs_Title;

	// Entry fields
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement first_name_Tab;
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement last_Name_Tab;
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement postal_code_Tab;

	// 2 Buttons at the bottom
	@FindBy(xpath = "//button[@id='cancel']")
	private WebElement cancel_Button;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continue_Button;

	// 2 icon at the top
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cart_Icon;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement menu_Button;

	// Constructor to initialize above WebElements
	public Checkout_Your_Information_4() {
		PageFactory.initElements(driver, this);
	}

	public String verify_Swag_Labs_Title() {
		return swag_Labs_Title.getText();
	}

	public String verify_Checkout_Info_Title() {
		return checkout_Info_Title.getText();
	}

	public String verify_Entry_Tab() {
		first_name_Tab.sendKeys("Om");
		last_Name_Tab.sendKeys("Jay");
		postal_code_Tab.sendKeys("440123");
		//continue_Button.click();
		return driver.getCurrentUrl();
	}

	public String verify_Cancel_Button() {
		this.verify_Entry_Tab();
		cancel_Button.click();
		return driver.getCurrentUrl();
	}

	public String verify_Continue_Button() {
		this.verify_Entry_Tab();
		continue_Button.click();
		return driver.getCurrentUrl();
	}

	public boolean verify_Cart_Icon() {
		return cart_Icon.isDisplayed();
	}

	public boolean verify_Menu_Icon() {
		return menu_Button.isDisplayed();
	}

	public String navigate_to_Checkout_Overview_Page() {
		this.verify_Entry_Tab();
		continue_Button.click();
		return driver.getCurrentUrl();
	}
}
