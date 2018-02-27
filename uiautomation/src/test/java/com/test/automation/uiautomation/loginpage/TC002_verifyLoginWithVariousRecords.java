package com.test.automation.uiautomation.loginpage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.testbase;
import com.test.automation.uiautomation.uiActions.LoginPage;

public class TC002_verifyLoginWithVariousRecords extends testbase {

	public static final Logger log=Logger.getLogger(TC001_verifyLoginWithInvalidCredentials.class.getName());
	LoginPage loginpage;
	//String U="yogeshthakur49@gmail.com";
	//String P="yogesh123";
	
	
	@DataProvider(name="testlogin")
	public String[][] getTestData()
	{
		String[][] testresults = getData("TestData.xlsx", "LoginTestData");
		return testresults;
	}
	@BeforeClass
	public void setup()
	{
		init();
	}
	
	@Test(dataProvider="testlogin")
	public void logintiSite(String U, String P, String runMode)
	{
		if(runMode.equalsIgnoreCase("n"))
		{
			throw new SkipException("User markd this records as no test");
		}
		
		log.info("*******starting TC002_verifyLoginWithVariousRecords Test********");
		loginpage = new LoginPage(driver);
		getScreenShot("logintiSite_"+U);
		loginpage.loginToApplication(U, P);
		
		loginpage.logout();
		log.info("*******Finished  TC002_verifyLoginWithVariousRecords Test********");
	}
	@AfterClass
	public void aftertest()
	{
		closeBrowser();
	}
}
