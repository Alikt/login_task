package com.app.login.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(id = "username")
    @iOSXCUITFindBy(id = "name")
    private MobileElement usernameField;

    @AndroidFindBy(id = "password")
    @iOSXCUITFindBy(id = "pass")
    private MobileElement passwordField;

    @AndroidFindBy(id = "loginButton")
    @iOSXCUITFindBy(id = "login")
    private MobileElement loginButton;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public DashboardScreen login(String username, String password, String appName) {
        isAppInstalled(appName);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DashboardScreen(driver);
    }
}