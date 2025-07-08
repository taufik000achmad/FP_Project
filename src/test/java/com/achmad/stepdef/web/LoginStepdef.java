package com.achmad.stepdef.web;

import com.achmad.base.BaseWebTest;
import com.achmad.page.web.HomepagePage;
import com.achmad.page.web.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepdef extends BaseWebTest {

    LoginPage loginpage;
    WebDriver driver = BaseWebTest.driver;
    Properties prop;
    HomepagePage homepagepage;

    String loggedInUsername;

    @Given("User is on landing page")
    public void userIsOnLandingPage() {
        driver = getDriver();
        loginpage = new LoginPage(driver, prop);
    }

    @When("User click header menu login")
    public void userClickHeaderMenuLogin() {

        loginpage.headerMenuLogin();
    }

    @And("User input username with {string}")
    public void userInputUsernameWith(String username) {

        loggedInUsername = username;
        loginpage.inputUsername(username);
    }

    @And("User input password with {string}")
    public void userInputPasswordWith(String password) {

        loginpage.inputPassword(password);
    }

    @And("User click button login")
    public void userClickButtonLogin() {

        loginpage.clickButtonLogin();
    }

    @Then("User able to see popup {string}")
    public void userAbleToSeePopup(String doesntExist) {

        loginpage.userDoesntExist(doesntExist);
    }

    @And("User click button close")
    public void userClickButtonClose() {

        loginpage.clickButtonCancel();
    }

    @Then("User back to landing page")
    public void userBackToLandingPage() {

        loginpage.validateOnLandingPage();
    }

    @Then("User is success login")
    public void userIsSuccessLogin() {

        homepagepage = new HomepagePage(driver, prop);

        String actualMessage = homepagepage.validateOnHomepage();
        String expectedMessage = "Welcome " + loggedInUsername;

        System.out.println("Expected: " + expectedMessage);
        System.out.println("Actual  : " + actualMessage);
        assertEquals(expectedMessage, actualMessage, "Welcome message is incorrect");
    }
}
