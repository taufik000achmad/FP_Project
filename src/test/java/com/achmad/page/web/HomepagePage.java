package com.achmad.page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomepagePage {

    static By verifUserLogin = By.id("nameofuser");
    By btnSlide = By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]");
    By btnNext = By.xpath("//*[@id=\"next2\"]");
    By btnPrevious = By.xpath("//*[@id=\"prev2\"]");
    By Image = By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[2]/img");
    By firstProduct = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    By thridProduct = By.cssSelector("a[href='prod.html?idp_=3']");
    By productDesc = By.xpath("//*[@id=\"more-information\"]/strong");

    WebDriver driver;
    Properties prop;

    public HomepagePage(WebDriver driver, Properties prop) {

        this.driver = driver;
        this.prop = prop;
    }


    public String validateOnHomepage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement userElement = wait.until(ExpectedConditions.visibilityOfElementLocated(verifUserLogin));
        return userElement.getText().trim();
    }

    public void setBtnSlide(){

        driver.findElement(btnSlide).click();
    }

    public String validateSlideImage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement slideImage = wait.until(ExpectedConditions.visibilityOfElementLocated(Image));
        return slideImage.getDomAttribute("src");
    }

    public void setBtnNext(){

        driver.findElement(btnNext).click();
    }

    public void waitForNextPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(firstProduct, "Apple monitor 24"));
    }

    public void validateNextPage(){

        WebElement productElement = driver.findElement(firstProduct);
        assertTrue(productElement.isDisplayed());
        assertEquals("Apple monitor 24", productElement.getText());
    }

    public void setBtnPrevious(){

        driver.findElement(btnPrevious).click();
    }

    public void waitForPreviousPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(firstProduct, "Nokia lumia 1520"));
    }

    public void validatePreviousPage(){

        WebElement productElement = driver.findElement(firstProduct);
        assertTrue(productElement.isDisplayed());
        assertEquals("Nokia lumia 1520", productElement.getText());
    }

    public void setThridProduct(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(thridProduct).click();
    }

    public void validateProductDesc(){

        WebElement productElement = driver.findElement(productDesc);
        assertTrue(productElement.isDisplayed());
        assertEquals("Product description", productElement.getText());
    }
}
