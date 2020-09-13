package com.automationpractice.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.automationpractice.util.LogHelper.log;

public class PropertyReader {
    private static volatile PropertyReader propInstance;

    private PropertyReader() {

    }

    public static synchronized PropertyReader getInstance() {
        if (propInstance == null)
            propInstance = new PropertyReader();
        return propInstance;
    }

    //method to get property value
    public String getProperty(String propertyName) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream("application.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null)
                return prop.getProperty(propertyName);
        } catch (IOException e) {
            log().info(e);
        }
        return null;
    }
}
