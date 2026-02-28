package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private static final String BASE_URI = "/api/auth/";

	public Response login(LoginRequest login) {
		return postRequest(login, BASE_URI + "login");
	}

	public Response signUp(SignupRequest signup) {
		return postRequest(signup, BASE_URI + "signup");
	}
}