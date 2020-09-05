package com.automationpractice.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;


public class ReporterHelper {

    @SuppressWarnings("rawtypes")
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(splitCamelCase(testName), "");
    }

    @SuppressWarnings("unchecked")
    public static synchronized ExtentTest startTest(String testName, String description) {
        ExtentTest test = extent.startTest(testName, description);
        extentTestMap.put((int) (Thread.currentThread().getId()), test);
        return test;
    }

    private static String splitCamelCase(String method) {
        return method.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        ).toUpperCase();
    }
}
