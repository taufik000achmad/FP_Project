package com.achmad.stepdef.api;

import com.achmad.page.api.GetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class GetStepdef {
    GetPage getPage = new GetPage();
    Response response;

    @Given("The user API is available")
    public void theUserAPIIsAvailable() {

        Response healthCheckResponse = getPage.apiHealthCheck();
        System.out.println("API Health Check Status: " + healthCheckResponse.getStatusCode());
        assertEquals(200, healthCheckResponse.getStatusCode());
    }

    @When("User request get all data")
    public void userRequestGetAllData() {
        response = getPage.getAllData();
    }

    @Then("The response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("The data format must be match with jsonschema")
    public void theDataFormatMustBeMatchWithJsonschema() {

        File schema = new File("src/test/resources/jsonschema/getListUserSchema.json");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
    }

    @When("User request get spesific data {string}")
    public void userRequestGetSpesificData(String userID) {
        
        response = getPage.getSpecificData(userID);
    }

    @Then("The id should be {string}")
    public void theIdShouldBe(String expectedID) {

        String actualID = response.jsonPath().getString("id");
        assertEquals(expectedID, actualID);
    }

    @When("User request get spesific wrong data {string}")
    public void userRequestGetSpesificWrongData(String wrongUserID) {

        response = getPage.getSpecificWrongData(wrongUserID);
    }

    @Then("User able to see error message {string}")
    public void userAbleToSeeErrorMessage(String expectedMessage) {

        String actualMessage = response.jsonPath().getString("error");
        assertEquals(expectedMessage, actualMessage);
    }
}
