
# Selenium E-Commerce Automation Framework

## Project Overview
This project automates key e-commerce workflows on [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver with Java. It demonstrates the Page Object Model (POM), TestNG-based testing, data-driven validation, HTML reporting, screenshots on failure, and execution logging.

## Tech Stack
- Java 17 language compatibility
- Selenium WebDriver 4.18.1
- TestNG 7.10.2
- Maven
- Chrome browser
- Log4j 2
- Extent Reports 5.1.2
- Eclipse IDE

## Framework Structure
```text
ECommerceAutomation/
├── pom.xml
├── README.md
├── logs/
│   └── automation.log
├── test-output/
│   └── ExtentReport.html
├── src/
│   └── test/
│       ├── java/
│       │   └── com/ecommerce/
│       │       ├── pages/
│       │       │   ├── LoginPage.java
│       │       │   ├── ProductsPage.java
│       │       │   ├── CartPage.java
│       │       │   └── CheckoutPage.java
│       │       ├── tests/
│       │       │   ├── BaseTest.java
│       │       │   ├── LoginTest.java
│       │       │   ├── ExtentReportManager.java
│       │       │   └── ExtentReportListener.java
│       │       └── utils/
│       │           ├── LoggerUtils.java
│       │           └── ScreenshotUtils.java
│       └── resources/
│           └── log4j2.xml
└── target/
    └── screenshots/
```

*Note: This structure reflects the files discussed in this project. Adjust it if your actual package or file locations differ.*

## Automated Test Scenarios
- Log in with valid credentials.
- Verify the Products page.
- Add Sauce Labs Backpack to the cart.
- Proceed through the checkout workflow.
- Validate required-field errors for first name, last name, and postal code.

## Test Execution

The framework has been verified using Maven.

Latest verified execution:
- Tests run: 4
- Passed: 4
- Failures: 0
- Errors: 0
- Skipped: 0

Run the complete test suite with:

```bash
mvn clean test


This documents your current verified result without changing any Java code.

## Next step

Before making any other README changes, let's confirm the folder structure. In Eclipse, where is `BaseTest.java` located: inside `com.ecommerce.tests`, or in a separate package?


## Framework Design
- **Page Object Model (POM):** Separates page locators and actions from test methods.
- **BaseTest:** Manages browser setup and teardown.
- **TestNG:** Organizes tests, assertions, and data-driven validation.
- **Explicit Waits:** Wait for relevant elements before interacting with them.
- **Maven:** Manages dependencies and test execution.
- **Extent Reports:** Generates an HTML execution report.
- **ScreenshotUtils:** Captures screenshots when tests fail.
- **Log4j 2:** Records execution information, warnings, and errors in the console and log file.

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

Run tests using Maven:

```bash
mvn test
```

You can also run the TestNG tests from Eclipse using **Run As → TestNG Test**.

## Reports and Logs
- **Extent Report:** `test-output/ExtentReport.html`
- **Execution Log:** `logs/automation.log`
- **Failure Screenshots:** `target/screenshots/`

Generated files and folders may need to be refreshed in Eclipse to become visible.

## Test Application
[SauceDemo](https://www.saucedemo.com/)

## Author
Surabhi Lodam

## Disclaimer
This project is intended for learning and demonstrating test automation skills on a demo application.
