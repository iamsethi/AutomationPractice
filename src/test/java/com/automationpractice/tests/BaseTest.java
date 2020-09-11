package com.automationpractice.tests;

import com.automationpractice.driver.DriverManager;
import com.automationpractice.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends DriverManager {
    protected HomePage homePage;

    @BeforeEach
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
        homePage.navigateToApp();
    }


}
