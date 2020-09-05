package com.automationpractice.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(className = "logout")
    private WebElement signOutLink;

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(css = ".lost_password > a")
    private WebElement forgotPasswordLink;

    @FindBy(className = "alert-danger")
    private WebElement alertBarDanger;

    @FindBy(className = "alert-success")
    private WebElement alertBarSuccess;

    @FindBy(css = "#form_forgotpassword > fieldset > p > button")
    private WebElement retrievePasswordButton;

    @FindBy(className = "lnk_wishlist")
    private WebElement wishListButton;

    public SignInPage(WebDriver driver, ExtentTest extentTest) {
        super(driver, extentTest);
    }
}
