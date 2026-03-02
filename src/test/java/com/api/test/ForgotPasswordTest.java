package com.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Forgot Password checks")
	public void checkForgotPassword() {

		AuthService authService = new AuthService();
		String emailAddress = "pramodv60@gmail.com";

		Response response = authService.forgotPassword(emailAddress);

		assertEquals(response.getStatusCode(), 200, "Forgot password endpoint should return OK!");
		assertTrue(!response.getBody().asString().isEmpty(), "Response body should not be empty");
		String expectedMessage = "If your email exists in our system, you will receive reset instructions.";
		assertTrue(response.getBody().asString().contains(expectedMessage),
				"Response should contain: " + expectedMessage);
	}
}