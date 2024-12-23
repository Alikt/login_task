package com.app.login.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BaseTest {

    protected AppiumDriver<MobileElement> driver;
    protected final boolean isAndroid;
    protected final boolean isIOS;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public BaseTest() {
        isAndroid = false;
        isIOS = true;
    }

    public SearchContext setUp() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities capabilities = getDesiredCapabilities();

        try {
            URI uri = new URI("http", null, "127.0.0.1", 4723, "/wd/hub", null, null);
            URL url = uri.toURL();
            if (isAndroid) {
                driver = new AndroidDriver<>(url, capabilities);
            }else {
                driver = new IOSDriver<>(url, capabilities);
            }
        } catch (URISyntaxException e) {
            logger.error("Invalid URI syntax for Appium server", e);
            throw e;
        } catch (MalformedURLException e) {
            logger.error("Invalid URL for Appium server", e);
            throw e;
        } catch (Exception e) {
            logger.error("Failed to initialize the Appium driver", e);
        }
        return driver;
    }

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (!isIOS) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("app", "app.apk");
        }else {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "simulator");
            capabilities.setCapability("app", "app.ipa");
        }
        return capabilities;
    }

    public void close_driver() {
        if (driver != null) {
            driver.quit();
        }
    }
}