package com.nextbase.step_definitions;

import com.nextbase.pages.DashBoardPage;
import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SendMessage_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("User login with {string} and {string} and user is on Dashboard page")
    public void userLoginWithAndAndUserIsOnDashboardPage(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.doLogin(username, password, true);
    }

    @When("user click message tab and send a message {string} and click send button")
    public void user_click_message_tab_and_send_a_message_and_click_send_button(String message) {
        dashBoardPage.sendMessage(message);
    }

    @Then("user should be able to send the message {string}")
    public void userShouldBeAbleToSendTheMessage(String message) {

        Assert.assertTrue(dashBoardPage.getSentMessage(message).isDisplayed());
    }

    @Then("user should be able to send the message {string} with a link {string}")
    public void userShouldBeAbleToSendTheMessageWithALink(String message, String linkText) {
        Assert.assertTrue(dashBoardPage.getSentMessage(message, linkText).isDisplayed());
    }


    @Then("user should be able to cancel the message")
    public void userShouldBeAbleToCancelTheMessage() {
        dashBoardPage.deleteMessage();
        Assert.assertTrue(dashBoardPage.messageDeletedText.isDisplayed());
    }

    @And("user click message tab and send a message {string} and click add link button and send link name {string} and send link address {string} and click save button and click send button")
    public void userClickMessageTabAndSendAMessageAndClickAddLinkButtonAndSendLinkNameAndSendLinkAddressAndClickSaveButtonAndClickSendButton(String message, String linkText, String linkURL) {
        dashBoardPage.sendMessage(message, linkText, linkURL);
    }

}
