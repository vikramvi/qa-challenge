package com.jodel.appium.framework;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class appiumDriverController {

    public static AppiumDriver<?> appiumDriverControllerDriver;

    public static void createDriver(String executionOS){
        try{
            DesiredCapabilities capabilities;

            if (appiumDriverControllerDriver != null) {
                return;
            }
            switch(executionOS){
                case "ANDROID":
                    File classpathRoot = new File(System.getProperty("user.dir"));
                    File appDir = new File(classpathRoot, "");
                    File app = new File (appDir, "Jodel.apk");

                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "placeholder string");
                    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60*5);
                    capabilities.setCapability("app", app.getAbsolutePath());
                    capabilities.setCapability("fullReset", false);

                    appiumDriverControllerDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;
                case "IOS":
                     //TBD
                     break;
                case "Chrome":
                     //TBD;
                     break;
                default:
                       System.out.println("WRONG DRIVER TYPE");
            }
        }catch(Exception e){
            e.getMessage();
        }

    }

    public static void stopDriver(){
        if (appiumDriverControllerDriver != null){
            appiumDriverControllerDriver.quit();
            appiumDriverControllerDriver = null;
        }
    }

    public static AppiumDriver<?> getDriver(){
        return appiumDriverControllerDriver;
    }

}
