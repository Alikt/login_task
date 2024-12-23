package com.app.login.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected final AppiumDriver <MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    protected boolean isAppInstalled(String appName) {
        return driver.isAppInstalled(appName);
    }

    protected Boolean isOnPage(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(17)).until(ExpectedConditions.textToBePresentInElement(element, element.getText()));
    }
}
