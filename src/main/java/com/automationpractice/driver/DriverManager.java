package com.automationpractice.driver;

import com.automationpractice.util.PropKey;
import com.automationpractice.util.PropertyReader;
import org.apache.logging.log4j.ThreadContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

import static com.automationpractice.util.LogHelper.log;

public class DriverManager extends DriverFactory {

    @BeforeAll
    public static void setUp() {
        prop = PropertyReader.getInstance();
        driver = getDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver = null;
        quitDriver();
    }

    @BeforeEach
    public void beforeEachMethod() {
        String strFile = "logs" + File.separator + prop
                .getProperty(PropKey.BROWSER.getPropVal()) + "_" + (int) (Math.random() * 10);
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        //route logs to separate file for each thread
        ThreadContext.put("ROUTINGKEY", strFile);
        log().info("log path: " + strFile);
    }
}
