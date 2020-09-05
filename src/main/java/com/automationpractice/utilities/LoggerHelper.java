package com.automationpractice.utilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class LoggerHelper {
    Logger logs;
    WebDriver driver;
    String screenshotPath = null;
    InitConfiguration conf = new InitConfiguration();
    ExtentTest extentTest;

    public LoggerHelper(WebDriver driver, ExtentTest extentTest) {
        this.extentTest = extentTest;
        this.logs = Logger.getLogger(Log.class.getName());
        InputStream log4j = null;

        log4j = this.getClass().getClassLoader()
                .getResourceAsStream("Config" + File.separator + "log4j.properties");

        PropertyConfigurator.configure(log4j);
        this.driver = driver;
    }

    public void info(String message) {
        Reporter.log("[INFO]: " + message, true);
        extentTest.log(LogStatus.INFO, message);
        logs.info(message);
    }

    public void debug(String message) {
        Reporter.log("[DEBUG]: " + message);
        logs.debug(message);
    }

    public void error(String message) {
        Reporter.log("[ERROR]: " + message);
        extentTest.log(LogStatus.ERROR, "[FAILED]: " + message);
        logs.error(message);
    }

    public void pass(String message) {
        Reporter.log("[PASSED]: " + message, true);
        extentTest.log(LogStatus.PASS, "[PASSED]: " + message);
        logs.info("[PASSED]: " + message);
    }

    public void warn(String message) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(screenshotPath + this.getClass().getSimpleName().toUpperCase() + ".png"));
            extentTest.log(LogStatus.WARNING, message + extentTest
                    .addBase64ScreenShot(extentTest.addScreenCapture(screenshotPath + this.getClass().getSimpleName().toUpperCase() + ".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("[WARN]: " + message, true);
        logs.warn(message);
    }

    public void fatal(String message) {
        Reporter.log("[FATAL]: " + message, true);
        logs.fatal(message);
    }

    public String getInfoLogs(String message) {
        extentTest.log(LogStatus.INFO, "[INFO]: " + message);
        return "[INFO] : " + message + "\n";
    }

    public String getErroLogs(String message) {
        return "[ERROR] : " + message + "\n";
    }

    public String getWarnLogs(String message) {
        logs.warn(message);
        return "[WARN] : " + message + "\n";
    }

    public String getFatalLogs(String message) {
        return "[FATAL] : " + message + "\n";
    }

}
