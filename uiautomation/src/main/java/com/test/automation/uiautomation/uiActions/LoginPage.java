package com.test.automation.uiautomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	WebDriver driver;
	@FindBy(xpath = "/html/body/div/div/header/div/div[2]/div/a/span[2]")
	WebElement Account;
	@FindBy(linkText = "Log In")
	WebElement LogIn;
	@FindBy(name = "login[username]")
	WebElement username;
	@FindBy(name = "login[password]")
	WebElement password;
	@FindBy(name = "send")
	WebElement send;
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/ul/li/ul/li/span")
	WebElement invalidlogin;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/a/span[2]")
	WebElement clickaccount;
	
	@FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[5]/a")
	WebElement logout;
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")
	WebElement homemyaccount;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String U, String P) {
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		Account.click();
		log.info("Clicked on Account and object is:-" + Account.toString());
		LogIn.click();
		log.info("Clicked on Login and object is:-" + LogIn.toString());
		username.clear();
		username.sendKeys(U);
		log.info("Enter the email:-" + U + " and object is:-" + username.toString());
		password.clear();
		password.sendKeys(P);
		log.info("Enter the Password:-" + P + " and object is:-" + password.toString());
		send.click();
		log.info("Click on the submit button and object is:-" + send.toString());
	}

	public String getinvalidlogintext() {
		log.info("the invalid login error  message is:-" + invalidlogin.getText());
		return invalidlogin.getText();
	}
	public void logout()
	{
		clickaccount.click();
		logout.click();
		//driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		homemyaccount.click();
	}
}
