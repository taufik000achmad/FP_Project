package com.achmad.page.api;

import com.achmad.base.BaseAPITest;
import io.restassured.response.Response;

import java.util.Map;

public class PutPage extends BaseAPITest {

    public PutPage() {
        BaseAPITest.setup();
    }

    public Response updateUser(String userId, Map<String, String> updateData) {

        return request
                .body(updateData)
                .when()
                .put("/user/" + userId);
    }
}
