package com.automationpractice.tests;

import com.automationpractice.steps.MyStoreSteps;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest extends MyStoreSteps {


    @Test
    @DisplayName("Add a new user to the store")
    void addNewUserToStoreAndVerifyLogin() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String addr1 = faker.address().buildingNumber();
        String addr2 = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = "00000";

        navigateToApp();
        navigateToSignOnPage();
        navigateToRegistrationPage(email);
        addPersonalInformation(firstName, lastName, password);
        addAccountInformation(firstName, lastName, phoneNumber, addr1, addr2,
                city, state, zipCode);
        clickSaveAccountInformation();

        assertAll(
                () -> assertEquals(firstName + " " + lastName, getGreetingMessage()),
                () -> assertTrue("Logout button is not displayed", isLogoutButtonDisplayed())
        );

    }
}
