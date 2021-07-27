package com.nextbase.pages;

import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordBox;


    @FindBy(xpath = "//input[@name='USER_REMEMBER']")
    public WebElement rememberMeBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@class='login-link-forgot-pass']")
    public WebElement forgotPasswordLink;

    public DashBoardPage doLogin(String username, String password, boolean rememberMe) {

        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

        usernameBox.sendKeys(username);

        passwordBox.sendKeys(password);

        if (rememberMe) {
            rememberMeBox.click();
        }

        loginButton.click();

        return new DashBoardPage();
    }


}
