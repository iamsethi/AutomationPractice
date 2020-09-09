package com.automationpractice.util;

public enum PropKey {
    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSER_MANAGER("browserManager"),

    //Driver Paths
    CHROME_DRIVER_PATH_WIN("chromeDriverPathWin"),
    GECKO_DRIVER_PATH_WIN("geckoDriverPathWin"),
    IE_DRIVER_PATH_WIN("ieDriverPathWin"),

    //Timeouts
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
