package com.ecommerce.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	public static String captureScreensshot(WebDriver driver, String testName) throws IOException {
		
		if(driver == null) {
			throw new IllegalArgumentException("WebDriver must not be null");
		}
		
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
		
		String safeTestName = testName.replaceAll("[^a-zA-Z0-9_-]", "_");
		
		Path screenshotDirectory = Path.of("target", "screenshots");
		
		Files.createDirectories(screenshotDirectory);
		
		Path destination = screenshotDirectory.resolve(safeTestName + "_" + timestamp + ".png");
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
		
		System.out.println("Screenshot Saved: " + destination.toAbsolutePath());
		
		return destination.toAbsolutePath().toString();
	}

}
