package com.nextbase.step_definitions;

import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

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

    @When("User enters following invalid username and password")
    public void userEntersFollowingInvalidUsernameAndPassword(Map<String, String> loginCredentials) {
        String username = loginCredentials.get("username");
        String password = loginCredentials.get("password");
        loginPage.doLogin(username, password, false);
    }

    @Then("user should be able to see the error message")
    public void user_should_be_able_to_see_the_error_message() {
       Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }


    @Given("user should be able to check remember me checkbox")
    public void user_should_be_able_to_check_remember_me_checkbox() {
        loginPage.rememberMeBox.click();
        Assert.assertTrue( loginPage.rememberMeBox.isSelected());
    }


    @Given("user should be able to access forgot password link")
    public void user_should_be_able_to_access_forgot_password_link() {
        loginPage.forgotPasswordLink.click();
        Assert.assertEquals("Get Password", driver.getTitle());
    }

}
