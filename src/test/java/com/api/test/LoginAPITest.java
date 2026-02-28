package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.*;

public class LoginAPITest {

	@Test(description = "Verify if Login is working")
	public void loginTest() {

		RestAssured.baseURI = "https://swift.techwithjatin.com/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json")
				.body("{\"password\":\"Bittergourd9731++\",\"username\":\"pramodv60@gmail.com\"}");

		Response response = request.post("/api/auth/login");

		assertEquals(response.getStatusCode(), 200, "Login should return 200 OK");
		assertTrue(response.getBody().asString().length() > 0, "Response body should not be empty");
	}
}