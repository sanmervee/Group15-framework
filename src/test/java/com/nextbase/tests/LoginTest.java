package com.nextbase.tests;

import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.ConfigurationReader;
import org.junit.Test;

public class LoginTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest1 () {
        loginPage.doLogin(ConfigurationReader.getProperty("helpdeskUsername"),
                ConfigurationReader.getProperty("helpdeskPassword"), false);
    }
}
