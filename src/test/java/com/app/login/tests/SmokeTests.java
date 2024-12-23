package com.app.login.tests;
import com.app.login.screens.DashboardScreen;
import com.app.login.screens.LoginScreen;
import com.app.login.setup.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTests extends BaseTest {

    @BeforeEach
    void setUP() throws MalformedURLException, URISyntaxException {
        setUp();
    }

    @Test
    void testLoginAndSearch() {
        LoginScreen loginPage = new LoginScreen(driver);
        DashboardScreen dashboardPage = new DashboardScreen(driver);

        loginPage.login("validUsername", "validPassword");
        assertTrue(driver.findElementById("dashboard").isDisplayed());

        dashboardPage.search("Me", "Mee");
        assertTrue(driver.findElementById("searchResult").isDisplayed());
    }

/*    @AfterEach
    void closeBrowser() {
        close_driver();
    }*/
}
