package com.test.automation.uiautomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductdetailsPage {
	WebDriver driver;
	public final String MOBILE = "mobile";
	public final String TV = "tv";
	public final String Sonyxperia = "sony-xperia";
	public final String IPHONE = "iphone";
	public final String Sonyxperialinktext = "Sony Xperia";
	public final String Iphonelinktext = "IPhone";

	@FindBy(xpath = "//button[@type='button']")
	WebElement AddtoCart;

	public ProductdetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonnavigationmenu(String menuName) {

		driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/" + menuName + ".html']")).click();

	}

	public void clickonProducts(String productname, String producttitle)

	{
		driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile/" + productname
				+ ".html'][contains(text(),'" + producttitle + "')]")).click();
	}

	public void Add_To_Cart_Button() {
		AddtoCart.click();
	}
	public String Verfiy_Item_In_Cart(String itemname)
	{
		return driver.findElement(By.xpath("//span[contains(text(),'"+itemname+" was added to your shopping cart.')]")).getText();
	}
}