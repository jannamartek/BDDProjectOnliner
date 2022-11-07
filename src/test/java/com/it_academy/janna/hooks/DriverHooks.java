package com.it_academy.janna.hooks;

import com.it_academy.janna.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.it_academy.janna.driver.DriverManager.getDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverHooks {
    private static final int IMPLICIT_WAIT_TIMEOUT = 30;
    private static final int PAGE_LOAD_TIMEOUT = 60;

    //запускают методы перед и после каждого сценария
    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}


