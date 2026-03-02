package com.api.base;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASEURI = "https://swift.techwithjatin.com/";
	private RequestSpecification requestSpecification;
	private Response response;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		requestSpecification = RestAssured.given().baseUri(BASEURI);
	}

	protected Response postRequest(Object payLoad, String endPoint) {
		response = requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
		return response;
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}

	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

	protected Response putRequest(Object payLoad, String endPoint) {
		response = requestSpecification.contentType(ContentType.JSON).body(payLoad).put(endPoint);
		return response;
	}
}