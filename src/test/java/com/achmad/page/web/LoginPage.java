package com.achmad.page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPage {
    By loginMenu = By.id("login2");
    By usernameInputText = By.id("loginusername");
    By passInputText = By.id("loginpassword");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By closeButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
    By landingPage = By.id("nava");

    WebDriver driver;
    Properties prop;

    public LoginPage(WebDriver driver, Properties prop) {

        this.driver = driver;
        this.prop = prop;

    }

    public void headerMenuLogin() {

        driver.findElement(loginMenu).click();
    }

    public void inputUsername(String username) {

        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String password) {

        driver.findElement(passInputText).sendKeys(password);
    }

    public void clickButtonLogin() {

        driver.findElement(loginButton).click();
    }

    public void userDoesntExist(String doesntExist){

        assertFalse(driver.getPageSource().contains(doesntExist));
    }

    public void clickButtonCancel() {

        driver.findElement(closeButton).click();
    }

    public void validateOnLandingPage(){

        WebElement productElement = driver.findElement(landingPage);
        assertTrue(productElement.isDisplayed());
        assertEquals("PRODUCT STORE", productElement.getText());
    }
}
