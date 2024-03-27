package com.petstore.qa.Utils;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIUtils {

    public Response getResponse(String url, String path, HashMap<String, String> headers) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(headers);
        Response response = httpRequest.request(Method.GET, path);
        return response;
    }

    public static Response postwithBodyAndParams(String url, String path, String payload, HashMap<String, String> params, HashMap<String, String> headers){
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(headers);
        httpRequest.body(payload);
        httpRequest.queryParams(params);
        Response response = httpRequest.request(Method.POST, path);
        return response;
    }

    public Response postWithBody(String url, String endpoint, HashMap<String, String> headers, String requestBody) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers(headers);
        httpRequest.body(requestBody);
        Response response = httpRequest.request(Method.POST, endpoint);
        return response;
    }
}
