package com.jodel.cucumber.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

import com.jodel.appium.framework.appiumHelpers;

public class jodelHomePage extends appiumHelpers{

    @AndroidFindBy(id="com.tellm.android.app:id/signup_button")
    MobileElement allowLocationButtonFromHomePage;

    @AndroidFindBy(id="com.tellm.android.app:id/order_by_time")
    MobileElement timeIcon;

    @AndroidFindBy(id="com.tellm.android.app:id/channelsIcon")
    MobileElement channelIcon;

    @AndroidFindBy(id="com.tellm.android.app:id/show_all")
    MobileElement showAllChannelsLink;

    @AndroidFindBy(id="com.tellm.android.app:id/karma_amount_text")
    MobileElement myKarmaAmountText;

    @AndroidFindBy(xpath="//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout")
    MobileElement myKarmaPageTitle;

    @AndroidFindBy(id="com.tellm.android.app:id/order_by_replies")
    MobileElement orderByRepliesIcon;

    @AndroidFindBy(id="com.tellm.android.app:id/order_by_votes")
    MobileElement votesIcon;

    @AndroidFindBy(id="com.tellm.android.app:id/text_search")
    MobileElement searchIcon;

    @AndroidFindBy(id="com.tellm.android.app:id/trending_today_text")
    MobileElement TendingTodayTitle;

    @AndroidFindBy(id="com.tellm.android.app:id/add_post_button")
    MobileElement postMessageButton;

    @AndroidFindBy(id="com.tellm.android.app:id/toolbar_bottom")
    MobileElement TermsConditionsAcceptButton;

    @AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView")
    MobileElement MesssageInputTextField;

    @AndroidFindBy(xpath="//android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
    MobileElement MessageInputScreenBackButton;


    protected final AppiumDriver driver;

    public jodelHomePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 1, TimeUnit.SECONDS), this);
    }

    public boolean gotoHomePage(){
        if(isElementPresent(allowLocationButtonFromHomePage,4)){
            allowLocationButtonFromHomePage.click();
            if(isHomePage()) {
                return true;
            }else{
                return false;
            }
        }else if(isElementPresent(timeIcon,5)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isHomePage(){
        if(isElementPresent(timeIcon,20)){
            return true;
        }else{
            return false;
        }
    }

    public void tapTrendingToday(){
        searchIcon.click();
    }

    public boolean isTrendingTodayPage(){
        if(isElementPresent(TendingTodayTitle,5)){
            return true;
        }else{
            return false;
        }
    }

    public void tapChannels(){
        channelIcon.click();
    }

    public boolean isChannelsPage(){
        if(isElementPresent(showAllChannelsLink,5)){
            getDriver().navigate().back();
            return true;
        }else{
            return false;
        }
    }

    public void tapMyKarma(){
        myKarmaAmountText.click();
    }

    public boolean isMyKarmaPage(){
        if(isElementPresent(myKarmaPageTitle,5)){
            getDriver().navigate().back();
            return true;
        }else{
            return false;
        }
    }

    public void gotoJodelInputScreen(){
        postMessageButton.click();
        if(isElementPresent(TermsConditionsAcceptButton,3)) {
            TermsConditionsAcceptButton.click();
        }
    }

    public boolean inputMessageAndGoBack(){
        if(isElementPresent(MesssageInputTextField,5)) {
            MesssageInputTextField.sendKeys("This is my first Jodel");
            MessageInputScreenBackButton.click();
            return true;
        }else{
            return false;
        }
    }

}
