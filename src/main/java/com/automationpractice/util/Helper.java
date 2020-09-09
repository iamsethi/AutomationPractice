package com.automationpractice.util;

public class Helper {
    /**
     * Method to obtain app url from
     * property file
     *
     * @return
     */
    public static String getAppUrl() {

        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        return baseUrl;
    }
}
