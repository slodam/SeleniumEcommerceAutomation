package com.ecommerce.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class ApiBaseTest {

	
//	@BeforeClass
//	public void setupApi() {
//		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//	}
	
	
	@BeforeClass
	public void setupApi() throws IOException{
		
		Properties properties = new Properties();
		
		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		
		properties.load(file);
		file.close();
		
		RestAssured.baseURI = properties.getProperty("baseURI");
				
	}
}
