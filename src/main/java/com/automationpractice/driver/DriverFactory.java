package com.automationpractice.driver;

import com.automationpractice.util.PropKey;
import com.automationpractice.util.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.automationpractice.util.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver == null)
            driverThreadLocal.set(getBrowserType().getWebDriver());
        driverThreadLocal.get().manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
        driverThreadLocal.get().manage().window().maximize();
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

    private static BrowserType getBrowserType() {
        if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase(BrowserType.CHROME.name())) {
            return BrowserType.CHROME;
        } else if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase(BrowserType.FIREFOX.name())) {
            return BrowserType.FIREFOX;
        } else return BrowserType.CHROME;
    }
}
