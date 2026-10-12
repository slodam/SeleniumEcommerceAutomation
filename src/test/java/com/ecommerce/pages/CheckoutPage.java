package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	private WebDriver driver;		//stores the browser driver so this page class can interact with the browser.
	
	public CheckoutPage(WebDriver driver) {			//the constructor receives the driver from the test.
		this.driver =driver;		//saves that driver for use by this page object.
		
	}
	
	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By postalCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By checkoutOverviewTitle = By.xpath("//span[@class = 'title' and text() = 'Checkout: Overview']");
	private By overviewProductName = By.className("inventory_item_name");
	private By finishButton = By.id("finish");
	private By confirmationMessage = By.className("complete-header");
	private By checkoutErrorMessage = By.cssSelector("[data-test='error']");
	
	public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
		
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(postalCodeField).sendKeys(postalCode);
	}
	
	public void clickContinue() {
		driver.findElement(continueButton).click();
}
	

	public String getCheckoutOverviewTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(checkoutOverviewTitle)).getText();
	}
	
	public String getOverviewProductName() {
		return driver.findElement(overviewProductName).getText();
	}
	
	public void clickFinish() {
		driver.findElement(finishButton).click();
	}
	
	public String getConfirmationMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
	}
	
	public String getCheckoutErrorMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(checkoutErrorMessage)).getText();
		
	}
}
