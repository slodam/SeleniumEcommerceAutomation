package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
		
	private WebDriver driver;
	
	//Constructor: receives the browser from LoginTest and stores it.
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By productTitles = By.className("title");
	private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
	private By cartIcon = By.className("shopping_cart_link");
	
	public String getProductTitle(){
		return driver.findElement(productTitles).getText();
	}
	
	public void addBackPackToCart(){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	
	}
	
	public void clickCart(){
		driver.findElement(cartIcon).click();
	}
}
