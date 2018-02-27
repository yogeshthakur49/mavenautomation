package com.test.automation.uiautomation.createaccountpage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.testbase;
import com.test.automation.uiautomation.uiActions.registrationpage;

public class TC001_verifytheregistrationpage extends testbase {

	public static final Logger log = Logger.getLogger(TC001_verifytheregistrationpage.class.getName());
	registrationpage registrationpage1;

	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void registration() {
		log.info("**********Starting registration test ****************");
		registrationpage1 = new registrationpage(driver);
		registrationpage1.registerusers("vijay", "bhagin", System.currentTimeMillis()+"@clickapps.co", "111111", "111111");
		Assert.assertEquals(registrationpage1.verifyregistration(),
				"Thank you for registering with Main Website Store.");
		log.info("**********Registration is done successfully****************");
		log.info("**********Finished registration test ****************");
	}

	@AfterClass
	public void endtest() {
		closeBrowser();
	}

}
