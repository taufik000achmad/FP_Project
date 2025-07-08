package com.achmad.runner.web;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = {"com.achmad"},
        features = {"src/test/resources/web-demoblaze/Cart.feature"},
        plugin = {"pretty","html:reports/web/cucumber_cart.html", "json:reports/web/cucumber_cart.json"}
)
public class CartRunner {
}
