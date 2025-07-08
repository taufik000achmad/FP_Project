package com.achmad.stepdef.web;

import com.achmad.base.BaseWebTest;
import com.achmad.page.web.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.junit.Assert.assertFalse;

public class CartStepdef extends BaseWebTest {
    WebDriver driver = BaseWebTest.driver;
    Properties prop;
    CartPage cartpage;

    @And("User click menu cart")
    public void userClickMenuCart() {

        cartpage.setBtnCart();
    }

    @And("User click product Nokia lumia1520")
    public void userClickProductNokiaLumia1520() {

        cartpage = new CartPage(driver, prop);
        cartpage.setSecondProduct();
    }

    @And("User click button add to cart")
    public void userClickButtonAddToCart() {

        cartpage.setBtnAddtoCart();
    }

    @Then("User able to see warning popup {string}")
    public void userAbleToSeeWarningPopup(String validatePopUp) {

        cartpage.validdatePopUp(validatePopUp);
    }

    @And("User click product Iphone632gb")
    public void userClickProductIphone632gb() {

        cartpage = new CartPage(driver, prop);
        cartpage.setFifthProduct();
    }

    @And("User click button ok")
    public void userClickButtonOk() {

        cartpage.setBtnOK();
    }

    @And("User click button delete")
    public void userClickButtonDelete() throws InterruptedException {

        cartpage.setBtnDelete();
        Thread.sleep(2000);
    }

    @Then("User success delete product")
    public void userSuccessDeleteProduct() {

        boolean isDeleted = cartpage.isProductDeleted();
        System.out.println("Is product deleted? " + isDeleted);
        assertFalse("Product still on cart", isDeleted);
    }

    @And("User click product HTC OneM9")
    public void userClickProductHTCOneM9() {

        cartpage = new CartPage(driver, prop);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        cartpage.setSeventhProduct();
    }

    @And("User click button place order")
    public void userClickButtonPlaceOrder() {

        cartpage.setBtnPlaceOrder();
    }

    @And("User input name with {string}")
    public void userInputNameWith(String nama) {

        cartpage.setInputNama(nama);
    }

    @And("User input country with {string}")
    public void userInputCountryWith(String country) {

        cartpage.setInputCountry(country);
    }

    @And("User input city with {string}")
    public void userInputCityWith(String city) {

        cartpage.setInputCity(city);
    }

    @Then("User input credit card with {string}")
    public void userInputCreditCardWith(String card) {

        cartpage.setInputCreditCard(card);
    }

    @And("User input month with {string}")
    public void userInputMonthWith(String month) {

        cartpage.setInputMonth(month);
    }

    @And("User input year with {string}")
    public void userInputYearWith(String year) {

        cartpage.setInputYear(year);
    }

    @And("User click button purchase")
    public void userClickButtonPurchase() {

        cartpage.setBtnPurchase();
    }

    @And("User click button close checkout")
    public void userClickButtonCloseCheckout() {

        cartpage.setBtnClose();
    }

    @Then("User is on Cart page")
    public void userIsOnCartPage() {

        cartpage.validateCartPage();
    }

    @Then("User able to see alert popup {string}")
    public void userAbleToSeeAlertPopup(String alertPopup0) {

        cartpage.alertPopUp(alertPopup0);
    }
}
