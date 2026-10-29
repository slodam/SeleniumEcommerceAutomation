package com.ecommerce.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetPostApiTest extends ApiBaseTest {

	@Test
	public void verifyGetPostById() {
		
		given()
			
		.when()
			.get("/posts/1")
		.then()
			.log().all()
			.statusCode(200)
			.body("userId", equalTo(1))
			.body("id", equalTo(1))
			.body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			.body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
	}
	
	@Test
	public void verifyCreatePost() {
		
		String requestBody= """
			{
				"title" : "Seleneium API Testing",
				"body" : "My First REST Assured POST test",
				"userId" : 1
			}
				""";
		given()
			
			.contentType("application/json")
			.body(requestBody)
		.when()
			.post("/posts")
		.then()
			.statusCode(201)
			.body("title", equalTo("Seleneium API Testing"))
			.body("body", equalTo("My First REST Assured POST test"))
			.body("userId", equalTo(1));
	}
	
	@Test
	public void verifyGetNonExistingPost() {
		
		given()
			
		.when()
			.get("/posts/999999")
		.then()
			.statusCode(404);
		
			
	}
	
	@DataProvider(name = "postIds")
	public Object[][] providePostIds(){
		
		return new Object[][] {
			{1},
			{2},
			{3}
		};
		
	}
	
	@Test(dataProvider = "postIds")
	public void verifyGetPostByIdDataDriven(int postId) {
		
		given()
			
		.when()
			.get("/posts/" + postId)
		.then()
			.statusCode(200)
			.body("id", equalTo(postId));
		
	}
}

