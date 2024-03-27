package com.petstore.qa.StepDefinitions;

import com.petstore.qa.Controller.PetServiceController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class GetPetByPetIdStepDefs {

    PetServiceController petServiceController = new PetServiceController();

    @Given("Pet Service")
    @Step("Pet Service")
    public void petService() {
        petServiceController.setEndpoint();
    }

    @When("We hit getPetByPetId endpoint with valid id {string}")
    @Step("We hit getPetByPetId endpoint with valid id {0}")
    public void weHitGetPetByPetIdEndpointWithValidId(String id) {
        petServiceController.GetPetByPetId(id);
    }

    @Then("We get statuscode {int}")
    @Step("We get statuscode {0}")
    public void weGetStatuscode(int statusCode) {
        petServiceController.checkStatusCode(statusCode);
    }

    @And("name field in response should be {string}")
    @Step("name field in response should be {0}")
    public void nameFieldInResponseShouldBe(String value) {
        petServiceController.validatePetName(value);
    }
}
