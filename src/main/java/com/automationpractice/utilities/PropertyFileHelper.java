package com.automationpractice.utilities;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileHelper {

    public Map<String, String> getValuesFromDefaultPropertyFile() {
        InputStream propertyFile;
        propertyFile = this.getClass().getClassLoader().getResourceAsStream("Config" + File.separator + "defaultConfig.properties");
        Map<String, String> propMap = new HashMap<String, String>();
        try {
            Properties p = new Properties();
            p.load(propertyFile);
            for (Object key : p.keySet()) {
                propMap.put(key.toString(), p.get(key).toString());
            }
            return propMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, String> getValuesFromPropertyFile(InputStream file) {
        HashMap<String, String> propMap = new HashMap<String, String>();
        try {
            Properties p = new Properties();
            p.load(file);
            for (Object key : p.keySet()) {
                propMap.put(key.toString(), p.get(key).toString());
            }
            return propMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
