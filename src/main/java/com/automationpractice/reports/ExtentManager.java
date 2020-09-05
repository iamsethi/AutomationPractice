package com.automationpractice.reports;

import com.automationpractice.utilities.InitConfiguration;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
    static ExtentReports extent;
    static String filePath = null;

    public synchronized static ExtentReports getReporter() {
        InitConfiguration conf = new InitConfiguration();
        filePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "ExtentReports" + File.separator + "Extent.html";
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
        }
        extent.assignProject("Automation Practice");
        extent.addSystemInfo(conf.getAllConfigurations());
        return extent;
    }
}
