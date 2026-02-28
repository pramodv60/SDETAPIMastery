package com.api.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Account creation checks")
	public void createAnAccount() {
		String unique = "test" + System.currentTimeMillis();
		String email = unique + "@test.com";

		SignupRequest signupRequest = SignupRequest.builder()
				.firstName("Test")
				.lastName("Test")
				.email(email)
				.password("Test12345678!")
				.mobileNumber("0123456789")
				.username(email)
				.build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);

		int status = response.getStatusCode();
		assertTrue(status >= 200 && status < 300,
				"Signup should return 2xx, got " + status + ". Response: " + response.asPrettyString());
		assertFalse(response.getBody().asString().isEmpty(), "Response body should not be empty");
	}
}