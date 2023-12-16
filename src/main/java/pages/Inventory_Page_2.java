package pages;


//day4
// here Object repository ; Contructor; methods

import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.Handle_Dropdown_List;

public class Inventory_Page_2 extends TestBase{

	//object Repository
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement addToCart  ;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement addToCartCount ;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortDropdown  ;
	@FindBy(xpath = "//span[@class='title']") private WebElement productsLabel ; 
	
	//BackPack Product all Xpaths 
	@FindBy(xpath = " //button[@id='add-to-cart-sauce-labs-backpack']") private WebElement  addTOCartBackpackProduct ;
	@FindBy(xpath = " (//div[@class='inventory_item_name '])[1]") private WebElement name_BackpackProduct  ;
	@FindBy(xpath = "//div[text()='29.99'] ") private WebElement price_BackpackProduct  ;
	@FindBy(xpath = " //img[@alt='Sauce Labs Backpack']") private WebElement image_BackpackProduct  ;
	
	
	//Rest of the products Xpaths for Adding to Add to Cart
	@FindBy(xpath = " //button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement  addTOCartBikeLight  ;
	@FindBy(xpath = " //button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement  addTOCartBoltTShirt ;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket'] ") private WebElement  addTOCartFleeceJacket ;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie'] ") private WebElement addTOCartOnesie  ;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement  addTOCartTShirtRed ;
	
	
	//Removing above added products -
	//'Contains' - is used for dynamic elements like here same thing - add/remove (so single element could be used for both)
	//But Contains usually NOT recommended to use
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackPack  ;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement  removeBikeLight ;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement  removeBoltTShirt ;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement  removeFleeceJacket ;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeOnesie  ;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeTShritRed  ;
		
	//Logs & Footer at the bottom
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement  twitterLogo ;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement  facebookLogo ;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement  linkedinLogo ;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement  swagLabFooterNote ;
	
	//Constructor to initialize above WebElements
	 public Inventory_Page_2 ()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public String verifyproductsLabel ()
	 {
		 return productsLabel.getText();
	 }
	 
	 public boolean verifytwitterLogo ()   //return type Boolean if logo visible- True ; if NOT - False
	 {
		 return twitterLogo.isDisplayed(); //True
	 }
	 
	 public boolean verifyfacebookLogo    ()
	 {
		 return facebookLogo.isDisplayed()  ;
	 }
	 
	 public boolean verifylinkedinLogo    ()
	 {
		 return linkedinLogo.isDisplayed()  ;
	 }
	 
	 public String verifyswagLabFooterNote_by_getText    ()
	 {
		 return swagLabFooterNote.getText()  ;
	 }
	 
	 public boolean verifyswagLabFooterNote_by_isDisplayed   ()
	 {
		 return swagLabFooterNote.isDisplayed()  ;
	 }
	 
	 
	//Now "Add to Cart" for all products is same type of function so writing them together
	//But before Add to Cart we will apply Sorting Filter (Its NOT compulsory)
	 public String add6Products () 
	 {
		 //for this drop-down we are writing another code in Utility
		 //Select sc = new Select(productSortDropdown);
		 //sc.selectByVisibleText("Price (low to high)"); //Here I applied filter 
		 //Now I will call drop-down code from utility 
		 
		 Handle_Dropdown_List.handleSelectClass(productSortDropdown, "Price (low to high)");
		 
		 addTOCartBackpackProduct.click();
		 addTOCartBikeLight.click();
		 addTOCartBoltTShirt.click();
		 addTOCartFleeceJacket.click();
		 addTOCartOnesie.click();
		 addTOCartTShirtRed.click();
		 
		 return addToCartCount.getText();
	 }
	 
	 //Just above is add method
	 //Now we need to remove some or all the added products 
	 //Since above add method is independent of below remove method
	 //So first add then Remove 
	 
	 
	 public String remove_2_Products ()
	 {
		//lets call add method to add products first 
		 add6Products();  //it will select all 6 elements (First add tehm remove)
		 
		// to remove we have to re-click them
		//But I want to remove only 2 products & keep the rest
		 removeBackPack.click();        //Clicked & Removed
		 removeBikeLight.click();       //Clicked & Removed
		
		 // removeBoltTShirt.click();    //Not Clicked & Stays in Cart
		 // removeFleeceJacket.click();
		 // removeOnesie.click();
		 // removeTShritRed.click();
		 
		 return addToCartCount.getText(); //AddCart Count = 4 (2 removed)
		 
	 }
	 
	 //This is written to navigate
	 public String navigate_to_Shopping_Cart ()
	    {
		 add6Products();
		 
		 addToCart.click();
		 		     	
	    	//once clicked navigate to next page
	    	//need that new web page URL -> https://www.saucedemo.com/cart.html
	    	return driver.getCurrentUrl();
	    }

	
	 

	 
	 
	
}
