package com.automationpractice.tests;

import com.automationpractice.steps.MyStoreSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest extends MyStoreSteps {

    @Test
    @DisplayName("As a valid user, a user must be able to login with valid credentials.")
    @Description("Logging into the app via sign on page")
    void doLogin() {
        navigateToApp();
        navigateToSignOnPage();
        doLogin("antonette.larkin@hotmail.com", "qi8vyw6lhuokc87");

        assertAll(
                () -> assertEquals("Jannette Nikolaus", getGreetingMessage()),
                () -> assertTrue("Logout button is not displayed", isLogoutButtonDisplayed())
        );

    }

}
