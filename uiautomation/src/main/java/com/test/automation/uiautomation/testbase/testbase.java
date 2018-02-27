package com.test.automation.uiautomation.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.test.automation.uiautomation.excelReader.Excel_Reader;


public class testbase {
	public static final Logger log = Logger.getLogger(testbase.class.getName());
	
	public static WebDriver driver;
	String URL = "http://live.guru99.com";
	String browser = "chrome";
	//Listener lis;
	Excel_Reader excelreader;
	public void init() {
		selectBrowser(browser);
		getURL(URL);
		String log4jconpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconpath);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			log.info("Creating the object:-" + browser);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			log.info("Creating the object:-" + browser);
			driver = new ChromeDriver();
		}
	}

	public void getURL(String URL) {
		log.info("navigating to the :-" + URL);
		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public String[][] getData(String excelname, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiautomation/data/"
				+ excelname;
		 excelreader = new Excel_Reader(path);
		String[][] data = excelreader.getDataFromSheet(excelname, sheetName);
		return data;
	}
//Method to capture the screen shot with data and time formatter
public void getScreenShot(String name) {
	Calendar calendar= Calendar.getInstance();
	SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiautomation/Screenshot/";
		File destFile=new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(srcFile, destFile);
		//this will helps to link the screenshot in testNG report
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/></a>");
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
	
}

public void closeBrowser()
{
	driver.quit();
	log.info("browser closed");
}
}
