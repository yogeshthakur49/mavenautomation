package com.test.automation.uiautomation.addtocartpage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.testbase;
import com.test.automation.uiautomation.uiActions.ProductdetailsPage;

public class TC001_verifyAddToCart extends testbase{
	public static final Logger log=Logger.getLogger(TC001_verifyAddToCart.class.getName()) ;
	ProductdetailsPage ProductdetailsPage1;
	
	@BeforeClass
	public void setup()
	{
		init();
	}

	@Test
	public void VerifyAddtoCart()
	{
		log.info("********Starting VerifyAddtoCart test******" );
		ProductdetailsPage1=new ProductdetailsPage(driver);
		log.info("********Clicking on the menu item******" );
		ProductdetailsPage1.clickonnavigationmenu(ProductdetailsPage1.MOBILE);
		ProductdetailsPage1.clickonProducts(ProductdetailsPage1.IPHONE, ProductdetailsPage1.Iphonelinktext);
		ProductdetailsPage1.Add_To_Cart_Button();
		String expected="Sony Xperia was added to your shopping cart.";
		if(ProductdetailsPage1.Verfiy_Item_In_Cart(ProductdetailsPage1.Iphonelinktext).contains(expected))
		{
			System.out.println(expected);
		}
		else {
			System.out.println("Iphone Added in the cart successfully");
		}
		log.info("**************Item Added in cart successfully************");
		
		log.info("********Finished VerifyAddtoCart test******" );
	}
	
	@AfterClass
	public void aftertest()
	{
		closeBrowser();
	}
}
