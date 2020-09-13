package com.automationpractice.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.automationpractice.util.Helper.getAppUrl;
import static com.automationpractice.util.LogHelper.log;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement login;


    /**
     * Navigate to app
     */
    @Step("Navigating to My Store Application")
    public void navigateToApp() {

        try {
            driver.navigate().to(new URL(getAppUrl()));
        } catch (MalformedURLException e) {
           log().info(e);
        }
    }

    /**
     * Method to navigate to sign in page
     *
     * @return
     */
    @Step("Navigating to Login Page")
    public LoginPage navigateToSignOnPage() {
        isTextPresentOnPage("My Store");
        clickLinkOrBtn(login);
        return new LoginPage(driver);
    }


}
