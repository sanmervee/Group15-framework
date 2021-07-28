package com.nextbase.step_definitions;

import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("User is on NextBase login page")
    public void user_is_on_next_base_login_page() {
        driver.get(ConfigurationReader.getProperty("URL"));
        Assert.assertEquals("Authorization", driver.getTitle());
    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {

        loginPage.doLogin(username, password, true);
    }
    @Then("User should see Dashboard Page")
    public void user_should_see_dashboard_page() {
        Assert.assertTrue(driver.getTitle().contains("Portal"));
    }

}
