package com.automationpractice.utilities;

import java.io.InputStream;
import java.util.Map;

public class InitConfiguration {
    Map<String, String> config = null;

    public InitConfiguration() {
        PropertyFileHelper prop = new PropertyFileHelper();
        config = prop.getValuesFromDefaultPropertyFile();

        for (String key : config.keySet()) {
            if (System.getProperties().containsKey(key))
                config.put(key, System.getProperty(key, config.get(key)));
        }
    }

    public InitConfiguration(InputStream file) {
        PropertyFileHelper prop = new PropertyFileHelper();
        config = prop.getValuesFromPropertyFile(file);
        for (String key : config.keySet()) {
            if (System.getProperties().containsKey(key))
                config.put(key, System.getProperty(key, config.get(key)));
        }
    }

    public Map<String, String> getAllConfigurations() {
        PropertyFileHelper prop = new PropertyFileHelper();
        config = prop.getValuesFromDefaultPropertyFile();
        return config;
    }

}
