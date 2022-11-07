package com.it_academy.janna.hooks;

import com.it_academy.janna.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHook {
    private static final String PNG_FILE_EXTENSION = "image/png";

    //запускает метод перед и после каждого сценария
    @After
    public void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, PNG_FILE_EXTENSION, scenario.getName());
    }
}

