package com.ecommerce.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utils.LoggerUtils;

@Listeners(ExtentReportListener.class)
public class LoginTest extends BaseTest {
	
	  @Test
	    public void verifyLogin() {
		  
		  // Create LoginPage object
		  LoginPage loginPage = new LoginPage(driver);
		  	  
		  // Perform login
		  loginPage.enterUserName("standard_user");
		  loginPage.enterPassword("secret_sauce");
		  loginPage.clickLogin();
		  
//		  // Verify Title
	      String PageTitle = driver.getTitle();
	      Assert.assertEquals(PageTitle, "Swag Labs");
		  
	      
	      // Create ProductsPage object
	      ProductsPage productspage = new ProductsPage(driver);

	      // Verify Products page
	      Assert.assertEquals(productspage.getProductTitle(), "Products");
	      
	      productspage.addBackPackToCart();
	      productspage.clickCart();
	      
	      CartPage cartpage = new CartPage(driver);
	      //System.out.println("Product in cart: " + cartpage.getProductName());
	      Assert.assertEquals(cartpage.getProductName(), "Sauce Labs Backpack");
	      cartpage.clickCheckout();
	      Assert.assertEquals(cartpage.getCheckoutPageTitle(), "Checkout: Your Information");
	      
	      CheckoutPage checkoutpage = new CheckoutPage(driver);
	      checkoutpage.enterCheckoutDetails("Surabhi", "Lodam", "411057");
	      checkoutpage.clickContinue();
	      System.out.println("URL after Continue: " + driver.getCurrentUrl());
	      
	      System.out.println("Page source contains error: "
	    	        + driver.getPageSource().contains("Error:"));
	      
	      Assert.assertEquals(checkoutpage.getCheckoutOverviewTitle(), "Checkout: Overview");
	      Assert.assertEquals(checkoutpage.getOverviewProductName(), "Sauce Labs Backpack");
	      
	      checkoutpage.clickFinish();
	      Assert.assertEquals(checkoutpage.getConfirmationMessage(), "Thank you for your order!");
	    }// end of verifyLogin()
	  
	  
//	 
	  @DataProvider(name = "checkoutValidationData")
	  public Object[][] checkoutValidationData(){
		  return new Object[][] {
			  {"","Lodam","411057","Error: First Name is required"},
			  {"Surabhi", "", "411057", "Error: Last Name is required"},
			  {"Surabhi", "Lodam", "", "Error: Postal Code is required"}
		  };
	 }
	  
	 @Test(dataProvider = "checkoutValidationData")
	 public void verifyCheckoutValidation(String firstName,
			 							  String lastName,
			 							  String postalCode,
			 							  String expectedError) {
		 
		 LoginPage loginpage = new LoginPage(driver);
		 loginpage.enterUserName("standard_user");
		 loginpage.enterPassword("secret_sauce");
		 loginpage.clickLogin();
		 
		 ProductsPage productspage = new ProductsPage(driver);
		 productspage.addBackPackToCart();
		 productspage.clickCart();
		 
		 CartPage cartpage = new CartPage(driver);
		 cartpage.clickCheckout();
		 
		 CheckoutPage checkoutpage = new CheckoutPage(driver);
		 checkoutpage.enterCheckoutDetails(firstName, lastName, postalCode);
		 
//		 System.out.println("First name entered: "
//			        + driver.findElement(By.id("first-name")).getAttribute("value"));
//			System.out.println("Last name entered: "
//			        + driver.findElement(By.id("last-name")).getAttribute("value"));
//			System.out.println("Postal code entered: "
//			        + driver.findElement(By.id("postal-code")).getAttribute("value"));
//			
		 checkoutpage.clickContinue();
		 
//		 System.out.println("URL after Continue: " + driver.getCurrentUrl());
//		 System.out.println("Page title: " + driver.getTitle());
//		 System.out.println("Error elements found: " +
//		         driver.findElements(By.cssSelector("[data-test='error']")).size());
//		 System.out.println("Page contains checkout error: " +
//		         driver.getPageSource().contains("Error:"));
		 
		 Assert.assertEquals(checkoutpage.getCheckoutErrorMessage(), expectedError);
		 
//		 System.out.println("Expected error: " + expectedError);
//
//		 System.out.println("Actual error element count: "
//		         + driver.findElements(By.cssSelector("[data-test='error']")).size());
//
//		 if (driver.findElements(By.cssSelector("[data-test='error']")).size() > 0) {
//		     System.out.println("Actual error text: "
//		             + driver.findElement(By.cssSelector("[data-test='error']")).getText());
//		 }
//
//		 Assert.assertTrue(
//		         driver.findElements(By.cssSelector("[data-test='error']")).size() > 0,
//		         "Checkout validation error was not displayed for: " + expectedError);
		 
	 }
	 
	
}
