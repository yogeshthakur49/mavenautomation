package com.test.automation.uiautomation.loginpage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.testbase;
import com.test.automation.uiautomation.uiActions.LoginPage;

import junit.framework.Assert;

public class TC001_verifyLoginWithInvalidCredentials extends testbase {
	public static final Logger log=Logger.getLogger(TC001_verifyLoginWithInvalidCredentials.class.getName());
	LoginPage loginpage;

	@BeforeTest
	public void setup() {
		init();
		/*
		 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		 * "/Drivers/geckodriver.exe"); driver=new FirefoxDriver();
		 * driver.get("http://live.guru99.com");
		 */

	}

	@Test
	public void verfiyLoginWithInvalidCredentials() {

		log.info("-----------------Starting verfiyLoginWithInvalidCredentials Test---------------" );
		loginpage = new LoginPage(driver);

		loginpage.loginToApplication("vijay@clickfdfapps.co", "vijay1");

		/*
		 * driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).
		 * click(); driver.findElement(By.linkText("Log In")).click();
		 * driver.findElement(By.name("login[username]")).clear();
		 * driver.findElement(By.name("login[username]")).sendKeys("vijay@clickapps.co")
		 * ; driver.findElement(By.name("login[password]")).clear();
		 * driver.findElement(By.name("login[password]")).sendKeys("vijay1");
		 * driver.findElement(By.name("send")).click();
		 */
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		Assert.assertEquals(loginpage.getinvalidlogintext(), "Invalid login or password.");
		log.info("-----------------Finished verfiyLoginWithInvalidCredentials Test---------------" );
	}

	@AfterTest
	public void endTest() {
		closeBrowser();
	}
}
