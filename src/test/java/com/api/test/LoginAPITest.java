package com.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.BaseService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest extends BaseService {

	@Test(description = "Verify if Login is working")
	public void loginTest() {

		AuthService authService = new AuthService();
		LoginRequest loginRequest = new LoginRequest("pramodv60@gmail.com", "Bittergourd9731++");

		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);

		String token = loginResponse.getToken();

		assertEquals(response.getStatusCode(), 200, "Login should return 200 OK");
		assertTrue(!response.getBody().asString().isEmpty(), "Response body should not be empty");
		assertNotNull(token, "Token not obtained!");
	}
}