package com.achmad.page.web;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage {

    By secondProduct = By.cssSelector("#tbodyid > div:nth-child(2) > div > div > h4 > a");
    By btnAddtoCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By fifthProduct = By.cssSelector("#tbodyid > div:nth-child(5) > div > div > h4 > a");
    //By btnOK = By.xpath("//button[contains(text(),'OK')]");
    By btnDelete = By.cssSelector("#tbodyid > tr:nth-child(1) > td:nth-child(4) > a");
    By productDelete = By.cssSelector("#tbodyid > tr:nth-child(1)");
    By seventhProduct = By.xpath("//*[@id=\"tbodyid\"]/div[7]/div/div/h4/a");
    By btnPlaceOrder = By.xpath("//button[text()='Place Order']");
    By inputName = By.id("name");
    By inputCountry = By.id("country");
    By inputCity = By.id("city");
    By inputCreditCard = By.id("card");
    By inputMonth = By.id("month");
    By inputYear = By.id("year");
    By btnClose = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By btnPurchase = By.xpath("//button[text()='Purchase']");
    By txtTotal = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/h2");
    By btnCart = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");


    WebDriver driver;
    Properties prop;

    public CartPage(WebDriver driver, Properties prop) {

        this.driver = driver;
        this.prop = prop;
    }

    public void setSecondProduct(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(secondProduct).click();
    }

    public void setBtnAddtoCart(){

        driver.findElement(btnAddtoCart).click();
    }

    public void validdatePopUp(String validatePopUp){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// Tunggu alert muncul
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
// Ambil teks dari alert
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
// Validasi teks alert sesuai harapan
        Assert.assertEquals(alertText, validatePopUp);
// Tutup alert (klik OK)
        alert.accept();
// validasi teks alertnya
        Assert.assertTrue(alertText.contains(validatePopUp));
    }

    public void alertPopUp(String alertPopUp){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.sweet-alert.showSweetAlert.visible")));

        WebElement title = popup.findElement(By.tagName("h2"));
        Assert.assertEquals("Thank you for your purchase!", title.getText());
    }

    public void setFifthProduct(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(fifthProduct).click();
    }

    public void setBtnOK(){

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnOK));
//        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
    }

    public void setBtnDelete(){

        driver.findElement(btnDelete).click();
    }

    public boolean isProductDeleted() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.invisibilityOfElementLocated(productDelete));
            System.out.println("Product berhasil terhapus");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Product masih ada");
            return false;
        }
    }

    public void setSeventhProduct(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(seventhProduct).click();
    }

    public void setBtnPlaceOrder(){

        driver.findElement(btnPlaceOrder).click();
    }

    public void setInputNama(String nama){

        driver.findElement(inputName).sendKeys(nama);
    }

    public void setInputCountry(String country){

        driver.findElement(inputCountry).sendKeys(country);
    }

    public void setInputCity(String city){

        driver.findElement(inputCity).sendKeys(city);
    }

    public void setInputCreditCard(String creditCard){

        driver.findElement(inputCreditCard).sendKeys(creditCard);
    }

    public void setInputMonth(String month){

        driver.findElement(inputMonth).sendKeys(month);
    }

    public void setInputYear(String year){

        driver.findElement(inputYear).sendKeys(year);
    }

    public void setBtnPurchase(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnPurchase));
        btn.click();
    }

    public void setBtnClose(){

        driver.findElement(btnClose).click();
    }

    public void validateCartPage(){

        WebElement productElement = driver.findElement(txtTotal);
        assertTrue(productElement.isDisplayed());
        assertEquals("Total", productElement.getText());
    }

    public void setBtnCart(){

        driver.findElement(btnCart).click();
    }
}
