package com.jodel.cucumber.steps.scenarios;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;
import static com.jodel.appium.framework.appiumServerController.*;
import com.jodel.cucumber.pages.*;

public class jodelHomePageScenariosSteps {

    protected jodelHomePage jodelHP;

    @Before
    public void setUp(Scenario scenario) throws Exception{
        jodelHP      =   new jodelHomePage(getDriver());
    }


    //------------------- GIVEN -----------------------

    @Given("App is in active state")
    public void launchJodelApp(){
        assertThat( jodelHP.gotoHomePage() ).isTrue();
    }


    //------------------- WHEN -----------------------

    @When("User taps on Trending Today")
    public void tapTrendingTodayStep(){
        jodelHP.tapTrendingToday();
    }

    @When("User taps on MYKARMA Score")
    public void tapMyKarmaStep(){
        jodelHP.tapMyKarma();
    }


    @When("User taps on Channels Icon")
    public void tapChannelsStep(){
        jodelHP.tapChannels();
    }

    @When("User taps on Post Message Icon")
    public void tapMessageInputIcon(){
        jodelHP.gotoJodelInputScreen();
    }

    //------------------- THEN -----------------------


    @Then("User is taken to Trending Today page")
    public void verifyTrendingTodayPage(){
        assertThat( jodelHP.isTrendingTodayPage() ).isTrue();
    }

    @Then("User is taken to MYKARMA page")
    public void verifyMyKarmaPage(){
        assertThat( jodelHP.isMyKarmaPage()).isTrue();
    }

    @Then("User is taken to Channels page")
    public void verifyChannelsPage(){
        assertThat( jodelHP.isChannelsPage() ).isTrue();
    }

    @Then("User can input text inside message input area")
    public void verifyUserCanInputText(){
        jodelHP.inputMessageAndGoBack();
    }

}
