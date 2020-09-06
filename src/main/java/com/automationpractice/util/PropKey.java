package com.automationpractice.util;

public enum PropKey {
    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSERMANAGER("browserManager");


    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
