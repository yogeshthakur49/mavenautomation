package com.test.automation.uiautomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registrationpage {

	public static final Logger log = Logger.getLogger(registrationpage.class.getName());

	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/a/span[2]")

	WebElement Account;
	@FindBy(linkText = "My Account")

	WebElement MyAccount;

	@FindBy(xpath = "//*[@id=\"login-form\"]/div/div[1]/div[2]/a/span/span")
	WebElement CreateAccount;
	@FindBy(name = "firstname")
	WebElement FirstName;

	@FindBy(name = "lastname")

	WebElement LastName;

	@FindBy(name = "email")

	WebElement Emailaddress;
	@FindBy(name = "password")

	WebElement Password;

	@FindBy(name = "confirmation")

	WebElement Confirmpassword;

	@FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button")

	WebElement Register;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")
	WebElement verifysuccessfullregistrationtext;

	public registrationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void registerusers(String Fname, String Lname, String Email, String Pass, String Confpass) {
		Account.click();
		log.info("click on account and object is:" + Account.toString());
		MyAccount.click();
		log.info("click on My account and object is:" + MyAccount.toString());
		CreateAccount.click();
		log.info("click on Create account button and object is:" + CreateAccount.toString());
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FirstName.sendKeys(Fname);
		log.info("Enter the  firstname is:- " + Fname + " and object is:" + FirstName.toString());
		LastName.sendKeys(Lname);
		log.info("Enter the lastname is :- " + Lname + " and object is:" + LastName.toString());
		Emailaddress.sendKeys(Email);
		log.info("Enter the email is:- " + Email + " and object is:" + Emailaddress.toString());
		Password.sendKeys(Pass);
		log.info("Enter the password is:- " + Pass + " and object is:" + Password.toString());
		Confirmpassword.sendKeys(Confpass);
		log.info("Enter the confirm password is:" + Confpass + " and object is:" + Confirmpassword.toString());
		Register.click();
		log.info("click on Register and object is:" + Register.toString());
	}

	public String verifyregistration() {
		log.info("your successfull register message is :-" + verifysuccessfullregistrationtext.getText().toString());

		return verifysuccessfullregistrationtext.getText();
	}
}
