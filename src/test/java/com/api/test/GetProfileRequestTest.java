package com.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test(description = "Get Profile request test")
	public void getProfileTest() {

		AuthService authService = new AuthService();
		LoginRequest loginRequest = new LoginRequest("pramodv60@gmail.com", "Bittergourd9731!");

		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());

		assertEquals(response.getStatusCode(), 200, "Get Profile should should return 200 OK");
		assertTrue(!response.getBody().asString().isEmpty(), "Response body should not be empty");
		assertNotNull(loginResponse.getToken(), "Token not obtained!");

		UserResponse userResponse = response.as(UserResponse.class);
		assertNotNull(userResponse.getId(), "User Id not obtained!");
	}
}