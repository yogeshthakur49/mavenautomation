package com.test.automation.uiautomation.customelistener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.test.automation.uiautomation.testbase.testbase;


public class Listener extends testbase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("testis starting:"+ result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String Methodname=result.getName();
		if(result.isSuccess())
		{
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiautomation/";
			File destFile=new File((String) reportDirectory + "/success_screenshot" + Methodname + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			//this will helps to link the screenshot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/></a>");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String Methodname=result.getName();
		if(!result.isSuccess())
		{
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiautomation/";
			File destFile=new File((String) reportDirectory + "/failure_screenshot" + Methodname + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			//this will helps to link the screenshot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/></a>");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext argo) {
		Reporter.log("test started" +argo.getStartDate().getTime() );
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
		
	}


