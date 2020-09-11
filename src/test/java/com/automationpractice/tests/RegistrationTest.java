package com.automationpractice.tests;

import com.automationpractice.pages.MyAccountPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)
@DisplayName("Registration Tests")
public class RegistrationTest extends BaseTest {


    @Test
    @DisplayName("Add a new user to the store")
    void addNewUserToStore() {

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
        Random r = new Random(System.currentTimeMillis());
        String zipCode = 10000 + r.nextInt(20000) + "";

        MyAccountPage myAccountPage = homePage
                .navigateToSignOnPage()
                .navigateToRegistrationPage(email)
                .addPersonalInformation(firstName, lastName, password)
                .addAccountInformation(firstName, lastName, phoneNumber, addr1, addr2,
                        city, state, zipCode)
                .clickSaveAccountInformation();

        assertAll(
                () -> assertEquals(firstName + " " + lastName, myAccountPage.getGreetingMessage()),
                () -> assertTrue("Logout button is not displayed", myAccountPage.isLogoutButtonDisplayed())
        );

    }
}
