package com.jodel.appium.framework;

import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;


public class appiumHelpers extends appiumDriverController{

    //Only works when pre declared element is passed and not when xpath or other identifier is used at run time
    public boolean isElementPresent(WebElement elementName, int timeout){
        //https://github.com/appium/java-client/issues/617
	/*try{
	        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
	        wait.until(ExpectedConditions.visibilityOf(elementName));
	        return true;
	}catch(Exception e){
	    return false;
	}*/
        try{
            int counter = 0;
            while(counter < timeout){
                Thread.sleep(1000);
                counter++;
                try{
                    if(elementName.isDisplayed()){
                        //if(ExpectedConditions.visibilityOf(elementName) !=null ){
                        return true;
                    }else{
                        continue;
                    }
                }catch(Exception e){
                    continue;
                }
            }
            System.out.println("ELEMENT NOT FOUND  -  " + elementName  + "  AFTER  " +  timeout  );
            return false;
        }catch(Exception e){
            return false;
        }
    }


    public boolean waitTillElementIsNotPresent(WebElement elementName, int timeout){
        int timeoutInterator = 0;
        while( timeoutInterator < timeout ){
            if( !isElementPresent(elementName,1)){
                return true;
            }else{
                timeoutInterator++;
            }
        }
        System.out.println("waitTillElementIsNotPresent TIMEOUT FAILURE");
        return false;
    }

    public void tapElement(WebElement elementToTap){
        TouchAction action = new TouchAction(getDriver());
        action.tap(elementToTap).perform();
    }
}
