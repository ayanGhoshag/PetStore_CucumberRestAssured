package com.petstore.qa.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"Features/Pets/GetPetByPetId.feature", "Features/Pets/AddPet.feature"},
        glue = "com/petstore/qa/StepDefinitions",
        plugin = "pretty"
)
public class myRunner extends AbstractTestNGCucumberTests {

}