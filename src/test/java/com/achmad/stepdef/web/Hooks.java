package com.achmad.stepdef.web;

import com.achmad.base.BaseWebTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public static void  setup(){
        BaseWebTest.getDriver();
    }

    @After
    public static void  quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        BaseWebTest.quitDriver();
    }
}
