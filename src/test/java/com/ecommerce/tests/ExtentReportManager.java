package com.ecommerce.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent == null) {
			
			 ExtentSparkReporter sparkReporter = 
					 new ExtentSparkReporter("test-output/ExtentReport.html");
			 
			 sparkReporter.config().setDocumentTitle("E-Commerce Automation Report");
			 sparkReporter.config().setReportName("Selenium Test Execution Report");
			 
			 extent = new ExtentReports();
			 extent.attachReporter(sparkReporter);
			 
			 extent.setSystemInfo("Project", "E-Commerce Automation");
			 extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
			 extent.setSystemInfo("Framework", "TestNG");
			 
		}
		
		return extent;
		
	
	}
}
