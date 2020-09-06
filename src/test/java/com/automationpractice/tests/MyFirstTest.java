package com.automationpractice.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("My Browser Tests")
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MyFirstTest extends BaseTest {

    @Test
        //  @DisplayName("Display name has highest precedence")
    void this_is_my_first_selenium_test() {
        String url = prop.getProperty("url");
        String port = prop.getProperty("port");

        driver.get(url + port);

    }
}
