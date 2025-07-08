package com.achmad.stepdef.web;

import com.achmad.base.BaseWebTest;
import com.achmad.page.web.HomepagePage;
import com.achmad.page.web.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class HomepageStepdef extends BaseWebTest {
    HomepagePage hompagepage;
    WebDriver driver = BaseWebTest.driver;
    Properties prop;
    LoginPage loginpage;

    String loggedInUsername;

    @Given("User doing login with {string} and {string}")
    public void userDoingLoginWithAnd(String username, String password) {

        loginpage = new LoginPage(driver, prop);
        loginpage.headerMenuLogin();
        loggedInUsername = username;
        loginpage.inputUsername(username);
        loginpage.inputPassword(password);
        loginpage.clickButtonLogin();
    }

    @When("User is on homepage")
    public void userIsOnHomepage() {

        hompagepage = new HomepagePage(driver, prop);

        String actualMessage = hompagepage.validateOnHomepage();
        String expectedMessage = "Welcome " + loggedInUsername;

        System.out.println("Expected: " + expectedMessage);
        System.out.println("Actual  : " + actualMessage);
        assertEquals(expectedMessage, actualMessage, "Welcome message is incorrect");
    }

    @And("User click button slide")
    public void userClickButtonSlide() {

        hompagepage.setBtnSlide();
    }

    @Then("User able to see second image")
    public void userAbleToSeeSecondImage() {

        String src = hompagepage.validateSlideImage();
        System.out.println("SRC Slide Image: " + src); //
        assertNotNull(src, "SRC image null, kemungkinan element tidak ditemukan");
        assertTrue(src.contains("nexus1.jpg"), "Slide image tidak sesuai");
    }

    @And("User scroll down")
    public void userScrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @And("User click next page")
    public void userClickNextPage() {

        hompagepage.setBtnNext();
        hompagepage.waitForNextPageLoad();
    }

    @Then("User is on next page")
    public void userIsOnNextPage() {

        hompagepage = new HomepagePage(driver, prop);
        hompagepage.validateNextPage();
    }

    @And("User click previous page")
    public void userClickPreviousPage() {

        hompagepage.setBtnPrevious();
        hompagepage.waitForPreviousPageLoad();
    }

    @Then("User is on previous page")
    public void userIsOnPreviousPage() {

        hompagepage = new HomepagePage(driver, prop);
        hompagepage.validatePreviousPage();
    }

    @And("User click product nexus6")
    public void userClickProductNexus6() {

        hompagepage.setThridProduct();
    }

    @Then("User able to see detail product Nexus6")
    public void userAbleToSeeDetailProductNexus6() {

        hompagepage.validateProductDesc();
    }
}
