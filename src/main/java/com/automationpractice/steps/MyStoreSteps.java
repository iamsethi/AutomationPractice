package com.automationpractice.steps;

import com.automationpractice.driver.DriverManager;
import com.automationpractice.pages.*;
import io.qameta.allure.Step;

public class MyStoreSteps extends DriverManager {

    private BasePage basePage = new BasePage(getDriver());
    private LoginPage loginPage = new LoginPage(getDriver());
    private ItemPage itemPage = new ItemPage(getDriver());
    private RegistrationPage registrationPage = new RegistrationPage(getDriver());
    private AccountsPage accountsPage = new AccountsPage(getDriver());

    /************************************************************************************************
     * **********************************************************************************************
     *
     * BASE PAGE STEPS
     *
     *************************************************************************************************
     *************************************************************************************************/
    @Step("Navigating to My Store Application")
    public void navigateToApp() {
        basePage.navigateToApp();
    }

    @Step("Navigating to Login Page")
    public LoginPage navigateToSignOnPage() {
        return basePage.navigateToSignOnPage();
    }

    /************************************************************************************************
     * **********************************************************************************************
     *
     * LOGIN PAGE STEPS
     *
     *************************************************************************************************
     *************************************************************************************************/

    @Step("Logging in with username: {0} & password: {1}")
    public ItemPage doLogin(String userName, String password) {
        return loginPage.doLogin(userName, password);
    }

    @Step("Navigating to user registration page with email: {0}")
    public RegistrationPage navigateToRegistrationPage(String email) {

        return loginPage.navigateToRegistrationPage(email);
    }

    /************************************************************************************************
     * **********************************************************************************************
     *
     * ACCOUNTS PAGE STEPS
     *
     *************************************************************************************************
     *************************************************************************************************/

    @Step("Adding new user information with customerFirstName: {0} , customerLastName: {1} , password {2}")
    public RegistrationPage addPersonalInformation(String customerFirstName, String customerLastName,
                                                   String password) {
        return registrationPage.addNewUserInformation(customerFirstName, customerLastName, password);
    }

    @Step("Adding account information- firstname:{0} , lastName:{1}," +
            " phone:{2}, addr1:{3}, addr2: {4}, city:{5}, " +
            "state:{6}, zip:{7}")
    public RegistrationPage addAccountInformation(String firstName,
                                                  String lastName,
                                                  String phone,
                                                  String addr1,
                                                  String addr2,
                                                  String city,
                                                  String state,
                                                  String zip) {


        return registrationPage.addAccountInformation(firstName,
                lastName,
                phone,
                addr1,
                addr2,
                city,
                state,
                zip);
    }

    @Step("Saving account information")
    public ItemPage clickSaveAccountInformation() {
        return registrationPage.clickSaveAccountInformation();

    }


    /************************************************************************************************
     * **********************************************************************************************
     *
     * ACCOUNTS PAGE STEPS
     *
     *************************************************************************************************
     *************************************************************************************************/
    @Step("Verify proper username is shown in the header")
    public String getGreetingMessage() {
        return accountsPage.getGreetingMessage();
    }

    @Step("Verify log out action is available")
    public boolean isLogoutButtonDisplayed() {
        return accountsPage.isLogoutButtonDisplayed();
    }


}



