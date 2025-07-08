package com.achmad.runner.web;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = {"com.achmad"},
        features = {"src/test/resources/web-demoblaze"},
        plugin = {"pretty","html:reports/web/cucumber_webrunner.html", "json:reports/web/cucumber_webrunner.json"}
)
public class RunnerWebTest {
}
