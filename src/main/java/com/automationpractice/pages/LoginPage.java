package com.automationpractice.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement createEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;


    /**
     * Method to login to the application
     *
     * @param userName
     * @param password
     * @return
     */
    @Step("Logging in with username: {0} & password: {1}")
    public MyAccountPage doLogin(String userName, String password) {

        enterTextIntoTextBox(emailField, userName);
        enterTextIntoTextBox(passwordField, password);

        clickLinkOrBtn(signInButton);
        return new MyAccountPage(driver);
    }

    /**
     * Method to navigate to registration page
     *
     * @return
     */
    @Step("Navigating to user registration page with email: {0}")
    public RegistrationPage navigateToRegistrationPage(String email) {
        enterTextIntoTextBox(createEmail, email);
        clickLinkOrBtn(createAccountButton);
        return new RegistrationPage(driver);
    }


}
