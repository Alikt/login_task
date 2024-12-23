package com.app.login.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardScreen {

    @FindBy(id = "com.example:id/searchField")
    private MobileElement searchField;

    @FindBy(id = "com.example:id/searchButton")
    private MobileElement searchButton;

    public DashboardScreen(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void search (String firstName, String lastName) {
        searchField.sendKeys(firstName + " " + lastName);
        searchButton.click();
    }
}