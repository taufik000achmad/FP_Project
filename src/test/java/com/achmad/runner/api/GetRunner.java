package com.achmad.runner.api;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = {"com.achmad.stepdef.api"},
        features = {"src/test/resources/api-dummyapi"},
        plugin = {"pretty","html:reports/api/cucumber_API.html", "json:reports/api/cucumber_API.json"},
        monochrome = true
)

public class GetRunner {
}
