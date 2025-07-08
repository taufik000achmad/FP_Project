package com.achmad.page.api;

import com.achmad.base.BaseAPITest;
import io.restassured.response.Response;

import java.util.Map;

public class PostPage extends BaseAPITest {

    public PostPage() {
        BaseAPITest.setup();
    }

    public Response createUser(Map<String, String> userData) {

        return request
                .body(userData)
                .when()
                .post("/user/create");
    }
}
