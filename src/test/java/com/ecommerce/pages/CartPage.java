package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By productName = By.className("inventory_item_name");
	private By checkoutButton = By.id("checkout");
	private By checkoutPageTitle = By.className("title");
	
	public String getProductName(){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement product = wait.until(
				ExpectedConditions.visibilityOfElementLocated(productName));
		
		return product.getText();
	}
	
	public void clickCheckout() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
		
}
	
	public String getCheckoutPageTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(driver -> {
			try {
				String heading = driver.findElement(checkoutPageTitle).getText();
				if(heading.equals("Checkout: Your Information")) {
					return heading;
				}
				return null;
				
			}catch(StaleElementReferenceException e) {
				return null;
			}
		
		});
	}
}