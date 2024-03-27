package com.petstore.qa.Controller;

import com.petstore.qa.Utils.RestAPIUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;

public class PetServiceController {

    String endpoint;
    Response response;
    HashMap<String, String> headers = new HashMap<>();
    RestAPIUtils restAPIUtils = new RestAPIUtils();

    public void setEndpoint() {
        endpoint = "/pet";
    }

    public void GetPetByPetId(String id) {
        headers.put("accept", "application/json");
        response = restAPIUtils.getResponse("https://petstore.swagger.io/v2", endpoint+"/"+id, headers);
    }

    public void checkStatusCode(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    public void validatePetName(String value) {
        JsonPath jsonPath = new JsonPath(response.asString());
        String name = jsonPath.get("name").toString();
        Assert.assertEquals(name, value);
    }

    public void validateStatusField(String value) {
        JsonPath jsonPath = new JsonPath(response.asString());
        String status = jsonPath.get("status").toString();
        Assert.assertEquals(status, value);
    }

    public void hitAddPetService(String requestBody) {
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        response = restAPIUtils.postWithBody("https://petstore.swagger.io/v2", endpoint, headers, requestBody);
    }
}
