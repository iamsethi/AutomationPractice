package com.automationpractice.pages;

import com.automationpractice.utilities.LoggerHelper;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private static final int TIMEOUT = 5;
    protected LoggerHelper log;
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, ExtentTest extentTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
        log = new LoggerHelper(this.driver, extentTest);
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToAppear(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void waitForElementToBeClickable(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}