package com.automationpractice.tests;

import org.junit.jupiter.api.Test;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MyFirstTest extends BaseTest {

    @Test
        //  @DisplayName("Display name has highest precedence")
    void this_is_my_first_selenium_test() {
        driver.get("http://localhost:8099/");

    }
}
