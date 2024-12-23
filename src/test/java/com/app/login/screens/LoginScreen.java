package com.app.login.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseScreen {

    @FindBy(id = "username")
    private MobileElement usernameField;

    @FindBy(id = "password")
    private MobileElement passwordField;

    @FindBy(id = "loginButton")
    private MobileElement loginButton;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public DashboardScreen login(String username, String password) {
        isAppInstalled();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DashboardScreen(driver);
    }
}