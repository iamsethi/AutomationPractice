package com.automationpractice.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserType implements DriverSetup {

    CHROME {
        @Override
        public WebDriver getWebDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver getWebDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }
};