package com.nextbase.step_definitions;

import com.nextbase.pages.DashBoardPage;
import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class CreatingPollStepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    WebDriver driver = Driver.getDriver();

    @And("the user clicks on the poll from dashboard and enters following info")
    public void theUserClicksOnThePollFromDashboardAndEntersFollowingInfo(Map<String, String> map) {
        // dashBoardPage.addPoll("", map.get("question"), map.get("answer1"), map.get("answer2"));
        dashBoardPage.addPoll("", map.get("question"), map.get("answer1"), map.get("answer2"));
    }

    @Then("the user sees {string} on the dashboard")
    public void the_user_sees_on_the_dashboard(String error) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dashBoardPage.pollErrorMessage));
        Assert.assertEquals(error, dashBoardPage.pollErrorMessage.getText());
    }


}
