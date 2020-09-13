package com.automationpractice.tests;

import com.automationpractice.pages.MyAccountPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Login Tests")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("As a valid user, a user must be able to login with valid credentials.")
    @Description("Logging into the app via sign on page")
    void doLogin() {
        MyAccountPage myAccountPage = homePage
                .navigateToSignOnPage()
                .doLogin("antonette.larkin@hotmail.com", "qi8vyw6lhuokc87");

        assertAll(
                () -> assertEquals("Jannette Nikolaus", myAccountPage.getGreetingMessage()),
                () -> assertTrue("Logout button is not displayed", myAccountPage.isLogoutButtonDisplayed())
        );

    }

}
