package com.app.login.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardScreen extends BaseScreen{

    @AndroidFindBy(id = "com.searchField")
    @iOSXCUITFindBy(id = "searchField")
    private MobileElement searchField;


    @AndroidFindBy(id = "com.searchButton")
    @iOSXCUITFindBy(id = "search")
    private MobileElement searchButton;

    public DashboardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public DashboardScreen isDashBoardAppears () {
        isOnPage(searchField);
        return this;
    }

    public void search (String firstName, String lastName) {
        searchField.sendKeys(firstName + " " + lastName);
        searchButton.click();
    }
}