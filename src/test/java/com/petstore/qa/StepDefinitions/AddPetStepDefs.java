package com.petstore.qa.StepDefinitions;

import com.petstore.qa.Controller.PetServiceController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import java.io.IOException;

import static com.petstore.qa.Utils.TestUtils.readJsonFileContents;

public class AddPetStepDefs {

    PetServiceController petServiceController = new PetServiceController();

    @When("user hits add pet endpoint with valid requestbody having id {string} and payload {string}")
    @Step("user hits add pet endpoint with valid requestbody having id {0} and payload {1}")
    public void userHitsAddPetEndpointWithValidRequestbodyHavingIdAndPayload(String id, String payload) throws IOException {
        String filepath = System.getProperty("user.dir") + "/DataRepository/" + payload + "_payload.json";
        String requestBody = readJsonFileContents(filepath);
        requestBody = requestBody.replace("9999", id);
        System.out.println("RequestBody is: "+requestBody);
        petServiceController.hitAddPetService(requestBody);
    }

    @Then("user gets statusCode {int}")
    @Step("user gets statusCode {0}")
    public void userGetsStatusCode(int statusCode) {
        petServiceController.checkStatusCode(statusCode);
    }


    @And("status field in response should be {string}")
    @Step("status field in response should be {0}")
    public void statusFieldInResponseShouldBe(String value) {
        petServiceController.validateStatusField(value);
    }

    @Given("Add Pet API")
    @Step("Add Pet API")
    public void addPetService() {
        petServiceController.setEndpoint();
    }
}
