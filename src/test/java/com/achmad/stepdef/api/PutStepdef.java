package com.achmad.stepdef.api;

import com.achmad.page.api.PutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PutStepdef {

    PutPage putPage = new PutPage();
    Response response;
    String dynamicEmail;

    @When("User sends a PUT request to update the user with id {string} and the following data:")
    public void userSendsAPUTRequestToUpdateTheUserWithIdAndTheFollowingData(String userId, io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> updateData = new HashMap<>(dataTable.asMap(String.class, String.class));
        response = putPage.updateUser(userId, updateData);
    }

    @And("The response body should contain {string} as {string}")
    public void theResponseBodyShouldContainAs(String expectedValue, String field) {
        String actualValue = response.jsonPath().getString(field);
        assertEquals(expectedValue, actualValue);
    }

    @When("User sends a PUT request to update the user with id {string} and email data:")
    public void userSendsAPUTRequestToUpdateTheUserWithIdAndEmailData(String userId, DataTable dataTable) {

        Map<String, String> updateData = new HashMap<>(dataTable.asMap(String.class, String.class));

        if (updateData.get("email").equals("dynamic")) {
            updateData.put("email", "test" + System.currentTimeMillis() + "@example.com");
        }

        response = putPage.updateUser(userId, updateData);
    }

    @And("The response body should contain the updated email")
    public void theResponseBodyShouldContainTheUpdatedEmail() {

        String actualEmail = response.jsonPath().getString("data.email");
        assertEquals(dynamicEmail, actualEmail);
    }

    @Then("The response status put should be {int}")
    public void theResponseStatusPutShouldBe(int expectedStatusCode) {

        assertEquals(expectedStatusCode, response.getStatusCode());
    }


    @And("The response body should contain error message {string}")
    public void theResponseBodyShouldContainErrorMessage(String expectedErrorMessage) {

        String actualError = response.jsonPath().getString("error");
        assertEquals(expectedErrorMessage, actualError);
    }
}
