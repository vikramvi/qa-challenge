package com.jodel.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.jodel.appium.framework.appiumServerController;

import org.junit.runner.RunWith;

import static com.jodel.appium.framework.appiumDriverController.createDriver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/jodelCriticalUserStories.feature"})
public class JodelCriticalUserStoriesTest {

    @BeforeClass
    public static void launchAppiumServer() throws MalformedURLException {
        appiumServerController.startAppiumServer();
        createDriver("ANDROID");
    }

    @AfterClass
    public static void killAppiumServer() throws IOException {
        appiumServerController.stopAppiumServer();
    }
}
