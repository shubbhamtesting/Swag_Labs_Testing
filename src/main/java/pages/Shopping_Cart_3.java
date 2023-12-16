package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
//import utility.Handle_Dropdown_List;

//Cart link
//Your Cart text
//QTY text
//Description text
//Open Menu - button
//Remove products - remove 3 & keep 3
//shopping_cart_badge (cart icon at top -> display number of items added to cart)
//continue-shopping - button
//checkout - button
//Each Product has - 1) cart_item_label 2) cart_quantity 3)inventory_item_desc 4)inventory_item_price 5) Remove button  
//Bottom -> 3 Logs & Footer Note

public class Shopping_Cart_3 extends TestBase {

	// All details of major displayed things on site (like - buttons, Titles)
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement shopping_cart_Icon; // Inventory to cart transfer Icon
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement addToCartIconCount;

	// All the text displayed
	@FindBy(xpath = "//span[@class='title']")
	private WebElement yourCart_Label; // Left-side corner
	@FindBy(xpath = "//div[@class='cart_quantity_label']")
	private WebElement cart_Quantity_Label;
	@FindBy(xpath = "//div[@class='cart_desc_label']")
	private WebElement cart_Description_label;

	// Open Menu
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement openMenu;
	// Inside Open Menu -> we check if text of Option is available or NOT
	@FindBy(xpath = "//a[text()='All Items']")//a[text()='About']
	private WebElement all_Items_Option_text;

	// At the bottom of Shopping Cart Page we have these two buttons
	@FindBy(xpath = "//button[@id='continue-shopping']")
	private WebElement continue_shoppingButton;
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkoutButton;

	// Removing above added products -
	// 'Contains' - is used for dynamic elements like here same thing - add/remove
	// (so single element could be used for both)
	// But Contains usually NOT recommended to use
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	private WebElement removeBackPack;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
	private WebElement removeBikeLight;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")
	private WebElement removeBoltTShirt;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")
	private WebElement removeFleeceJacket;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")
	private WebElement removeOnesie;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")
	private WebElement removeTShritRed;

	// Logs & Footer at the bottom
	@FindBy(xpath = "//a[text()='Twitter']")
	private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']")
	private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")
	private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']")
	private WebElement swagLabFooterNote;

	// BackPack Product all Xpaths
	@FindBy(xpath = " //div[text()='Sauce Labs Backpack']")
	private WebElement back_Pack_Name;
	@FindBy(xpath = "//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']")
	private WebElement back_Pack_Description;
	@FindBy(xpath = "//div[text()='29.99'] ")
	private WebElement backpackProduct_Price;
	
	//Xpath of Checkout page -> from navigating from Cart to Checkout Page
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkout_Page_Button;

	// Constructor to initialize above WebElements
	public Shopping_Cart_3() {
		PageFactory.initElements(driver, this);
	}

	public String verify_Shopping_Cart_Icon() {
		return driver.getCurrentUrl(); // https://www.saucedemo.com/cart.html
	}

	public String verify_continue_shoppingButton() {
		continue_shoppingButton.click();
		return driver.getCurrentUrl(); // https://www.saucedemo.com/inventory.html
	}

	public String verify_checkoutButton() {
		checkoutButton.click();
		return driver.getCurrentUrl(); // https://www.saucedemo.com/checkout-step-one.html
	}

	// cart_Quantity_Label
	public String verify_cart_Quantity_Label() {
		return cart_Quantity_Label.getText();
	}

	public String verify_Your_Cart_Label() {
		return yourCart_Label.getText();
	}

	public boolean verify_twitterLogo() // return type Boolean if logo visible- True ; if NOT - False
	{
		return twitterLogo.isDisplayed(); // True
	}

	public boolean verify_facebookLogo() {
		return facebookLogo.isDisplayed();
	}

	public boolean verify_linkedinLogo() {
		return linkedinLogo.isDisplayed();
	}

	public boolean verify_swagLabFooterNote_by_isDisplayed() {
		return swagLabFooterNote.isDisplayed();
	}

	public String verify_Open_Menu_Clickable() {
		openMenu.click();
		return all_Items_Option_text.getText();
	}

	public String verify_Open_Menu_Click_againclick_All_Items_Navigate() throws InterruptedException {
		openMenu.click();
		Thread.sleep(5000);
		all_Items_Option_text.click();
		return driver.getCurrentUrl();
	}

	// Just above is add method
	// Now we need to remove some or all the added products
	// Since above add method is independent of below remove method
	// So first add then Remove
	

	public String verify_BackPack_Product_Description() {
		return back_Pack_Description.getText();
	}

	// Error
	public String verify_BackPack_Price() {
		return backpackProduct_Price.getText();
	}

	public String verify_BackPack_Product_Name() {
		return back_Pack_Name.getText();
	}

	public String verify_BackPack_Product_CLick_Redirecting() {
		back_Pack_Name.click();
		return driver.getCurrentUrl();
	}
	
	public String remove_3_Products() {

		// lets call add method to add products first
		// add6Products(); //it will select all 6 elements (First add tehm remove)
		// to remove we have to re-click them
		// But I want to remove only 2 products & keep the rest
		removeBackPack.click(); // Clicked & Removed
		removeBikeLight.click(); // Clicked & Removed
		removeBoltTShirt.click();

		// removeFleeceJacket.click(); //Not Clicked & Stays in Cart
		// removeOnesie.click();
		// removeTShritRed.click();

		return addToCartIconCount.getText(); // AddCart Count = 4 (2 removed)

	}
	
	public String navigate_to_Checkout_Page ()
	{
		checkout_Page_Button.click();
		return driver.getCurrentUrl();
	}
	
}
