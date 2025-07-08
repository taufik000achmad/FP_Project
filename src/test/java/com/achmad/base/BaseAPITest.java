package com.achmad.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseAPITest {
    protected static RequestSpecification request;
    protected static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setup() {
        RestAssured.baseURI = prop.getProperty("apibaseUrl");
        request = RestAssured.given()
                .header("app-id", prop.getProperty("appId"))
                .contentType("application/json");
    }

    public Response apiHealthCheck() {
        setup();
        return request.when().get("/user");

    }
}
