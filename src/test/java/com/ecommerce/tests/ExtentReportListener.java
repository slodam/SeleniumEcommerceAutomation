package com.ecommerce.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecommerce.utils.LoggerUtils;
import com.ecommerce.utils.ScreenshotUtils;

public class ExtentReportListener implements ITestListener {
	
	private ExtentReports extent = ExtentReportManager.getInstance();
	//private ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	 @Override
	    public void onStart(ITestContext context) {
	        extent = ExtentReportManager.getInstance();
	    }
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		LoggerUtils.info("The test is started: " + result.getMethod().getMethodName());
		ExtentTest extentTest = 
				extent.createTest(result.getMethod().getMethodName()); 	//creates a report entry using the test method's name.
		
		test.set(extentTest);	//stores that entry for the current thread.
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		LoggerUtils.info("Test Passed: " + result.getMethod().getMethodName());
		test.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		LoggerUtils.error("Test Failed: " + result.getMethod().getMethodName() + " | Reason: " +result.getThrowable());
		
		test.get().log(Status.FAIL, result.getThrowable());
		//Status.FAIL marks the test as failed in the HTML report.
		//result.getThrowable() captures the exception or error that caused the failure.
		
		
		// Get the object of the test class in which the failure occurred.
			Object instance = result.getInstance();
			
		// Check whether the test class inherits from BaseTest.
		// BaseTest contains the WebDriver instance.
			if(instance instanceof BaseTest) {
				
				 // Get the browser driver from BaseTest.
				WebDriver driver = ((BaseTest)instance).driver;
				
				// Take a screenshot only if the driver exists.
				if(driver != null) {
					try {
						
						String screenshotPath = ScreenshotUtils.captureScreensshot(driver, result.getMethod().getMethodName());
						
						String relativePath = "../target/screenshots/"
						        + Paths.get(screenshotPath).getFileName().toString();

						test.get().addScreenCaptureFromPath(relativePath);

						System.out.println("Screenshot attached to Extent Report: " + relativePath);
												
					}catch(IOException e) {
						// If saving the screenshot fails, record a warning in the report.
						test.get().log(Status.WARNING, "Could not save the screenshot: " + e.getMessage());
					}
					
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		LoggerUtils.warn("Test Skipped: " + result.getMethod().getMethodName());
		test.get().log(Status.SKIP, "Test Skipped");
	}

	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
