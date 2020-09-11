package com.automationpractice.util;

import com.automationpractice.driver.BrowserType;

public class SystemPropertyHelper {

    /**
     * Method to get value for elementScreenShot
     *
     * @return
     */
    public static String getElementScreenShotValue() {

        String msg = "";

        String valueFromPropFile = PropertyReader.getInstance()
                .getProperty(PropKey.ELEMENT_SCREEN_SHOT.getPropVal());

        String valueFromSystemVariable = System.getProperty("elementScreenShot");

        if (valueFromSystemVariable.length() > 0) {

            if (valueFromSystemVariable.equalsIgnoreCase("ENABLE") ||
                    valueFromSystemVariable.equalsIgnoreCase("DISABLE")) {

                return valueFromSystemVariable;
            } else {

                msg = "Incorrect system property " + valueFromSystemVariable + " value specified for"
                        + PropKey.ELEMENT_SCREEN_SHOT.getPropVal() +
                        " ...defaulting to property provided by the application.properties file " +
                        PropKey.ELEMENT_SCREEN_SHOT.getPropVal() + " : " + valueFromPropFile;
                System.out.println(msg);
            }
        }

        msg = "No system property specified" +
                " ...defaulting to application.properties file ->  " +
                PropKey.ELEMENT_SCREEN_SHOT.getPropVal() + " : " + valueFromPropFile;

        System.out.println(msg);
        return valueFromPropFile;
    }


    /**
     * Get browser value from pom.xml
     *
     * @return
     */
    public static BrowserType getBrowserFromSystemVariable() {

        String browser = System.getProperty(PropKey.BROWSER.getPropVal());

        if (browser.length() <= 0) {
            browser = PropertyReader.getInstance().getProperty(PropKey.BROWSER.getPropVal());
        }

        if (browser.equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        } else if (browser.equalsIgnoreCase("FIREFOX")) {

            return BrowserType.FIREFOX;
        } else {
            return null;
        }
    }
}
