package com.automationpractice.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(className = "logout")
    private WebElement logout;

    /**
     * Get greeting message
     *
     * @return
     */
    @Step("Verify proper username is shown in the header")
    public String getGreetingMessage() {
        return getTextFromElement(accountName);
    }

    /**
     * Logout button
     *
     * @return
     */
    @Step("Verify log out action is available")
    public boolean isLogoutButtonDisplayed() {
        return logout.isDisplayed();
    }
}
