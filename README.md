
# Selenium E-Commerce Automation

## Project Overview
This project automates key e-commerce workflows on [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver with Java. It demonstrates UI automation, the Page Object Model (POM), and test execution with TestNG and Maven.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Chrome browser
- Eclipse IDE

## Framework Structure
```text
ECommerceAutomation/
├── pom.xml
├── README.md
└── src/
    └── test/
        └── java/
            └── com/
                └── ecommerce/
                    ├── pages/
                    │   ├── LoginPage.java
                    │   ├── ProductsPage.java
                    │   ├── CartPage.java
                    │   └── CheckoutPage.java
                    └── tests/
                        ├── BaseTest.java
                        └── LoginTest.java
```

## Automated Test Scenarios
- Login with valid credentials.
- Verify the Products page.
- Add Sauce Labs Backpack to the cart.
- Verify the cart contents.
- Proceed to checkout.
- Complete checkout and verify the order confirmation.
- Validate required-field errors for first name, last name, and postal code.

## Framework Design
- **Page Object Model:** Separates page locators and actions from test methods.
- **BaseTest:** Manages browser setup and teardown.
- **TestNG:** Organizes and executes automated tests and assertions.
- **Explicit Waits:** Wait for relevant elements to become visible or clickable.
- **Maven:** Manages project dependencies and build configuration.

## Prerequisites
- Java JDK
- Maven
- Google Chrome
- Git

## Run the Tests
Clone the repository:

```bash
git clone https://github.com/slodam/SeleniumEcommerceAutomation.git
cd SeleniumEcommerceAutomation
```

Run the TestNG tests through Maven:

```bash
mvn test
```

Ensure the Maven Surefire configuration discovers your TestNG test class before relying on `mvn test`. You can also run `LoginTest.java` directly from Eclipse using TestNG.

## Test Application
https://www.saucedemo.com/

## Author
Surabhi Lodam

## Disclaimer
This project is intended for learning and demonstrating test automation skills on a demo application.
