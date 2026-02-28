package com.api.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Account creation checks")
	public void createAnAccount() {

		SignupRequest signupRequest = SignupRequest.builder()
				.firstName("Test")
				.lastName("Test")
				.email("test@test.com")
				.password("Test12345678!")
				.mobileNumber("0123456789")
				.username("unique_unique_username1@test.com")
				.build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);

		assertTrue(response.asPrettyString().contains("success"), "User registration failed!");
	}
}