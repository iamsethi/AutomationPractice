package com.automationpractice.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.automationpractice.util.PropKey.PORT;
import static com.automationpractice.util.PropKey.URL;

@DisplayName("My Browser Tests")
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MyFirstTest extends BaseTest {

    @Test
        //  @DisplayName("Display name has highest precedence")
    void this_is_my_first_selenium_test() {
        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());

        driver.get(url + port);

    }
}
