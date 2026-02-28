package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASEURI = "https://swift.techwithjatin.com/";
	private RequestSpecification requestSpecification;
	private Response response;

	public BaseService() {
		requestSpecification = RestAssured.given().baseUri(BASEURI);
	}

	protected Response postRequest(Object payLoad, String endPoint) {
		response = requestSpecification
				.contentType(ContentType.JSON)
				.body(payLoad)
				.log().body()
				.post(endPoint);
		return response;
	}
}