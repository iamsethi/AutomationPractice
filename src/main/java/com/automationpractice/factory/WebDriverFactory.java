package com.automationpractice.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver getDriver(Map<String, String> config) {
        return getBrowserDriver(config);
    }

    public static WebDriver getBrowserDriver(Map<String, String> config) {
        String browser = config.get("browser").toLowerCase();
        WebDriver driver;
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver = new EdgeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Incorrect browser name - " + browser);
        }
        driver.manage().window().maximize();
        driver.get(config.get("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.get("implicitWait")), TimeUnit.SECONDS);
        return driver;
    }

}// WebDriverFactoryEnds
