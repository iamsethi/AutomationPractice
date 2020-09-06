package com.automationpractice.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {
    static WebDriver driver;

    @Test
    void lauchBrowser() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/linux/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://localhost:8099/");
        driver.quit();
    }
}
