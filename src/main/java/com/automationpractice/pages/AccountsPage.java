package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage {

    public AccountsPage(WebDriver driver) {
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
    public String getGreetingMessage() {
        return getTextFromElement(accountName);
    }

    /**
     * Logout button
     *
     * @return
     */
    public boolean isLogoutButtonDisplayed() {
        return logout.isDisplayed();
    }
}
