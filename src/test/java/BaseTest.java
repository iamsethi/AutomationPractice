import com.automationpractice.factory.WebDriverFactory;
import com.automationpractice.reports.ExtentManager;
import com.automationpractice.reports.ReporterHelper;
import com.automationpractice.utilities.InitConfiguration;
import com.automationpractice.factory.ThreadLocalDriver;
import com.automationpractice.utilities.YamlReader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static HashMap<String, Object> commondata = new HashMap<String, Object>();
    protected ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    protected String testMethod = new String();

    @BeforeSuite
    public void beforeSuite() {
        commondata = (HashMap<String, Object>) YamlReader.loadUserDataYaml(this.getClass().getClassLoader()
                .getResourceAsStream("TestData" + File.separator + "CommonData.yml")).get("CommonData");
    }

    @BeforeTest
    public void beforeTest() {
        /*
         * Initializing common configuration of execution
         */
        InputStream configFile = this.getClass().getClassLoader()
                .getResourceAsStream("Config" + File.separator + "defaultConfig.properties");
        InitConfiguration conf = new InitConfiguration(configFile);
        Map<String, String> config = conf.getAllConfigurations();

        try {
            String baseUrl = System.getProperty("baseUrl", config.get("baseUrl"));
            String browser = System.getProperty("browser", config.get("browser"));
            for (String key : config.keySet()) {
                if (key.equalsIgnoreCase("baseUrl")) {
                    config.put(key, baseUrl);
                }
                if (key.equalsIgnoreCase("browser")) {
                    config.put(key, browser);
                }
            }
            System.out.println("config after" + config.entrySet());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ThreadLocalDriver.setTLDriver(WebDriverFactory.getDriver(config));
/*

        String envn = config.get("environment");
        String value = envdata.get(envn).toString().substring(1, envdata.get(envn).toString().length() - 1);
        String[] keyValuePairs = value.split(",");

        for (String pair : keyValuePairs) {
            String[] entry = pair.split("=");
            commondata.put(entry[0].trim(), entry[1].trim());
        }
*/

    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        testMethod = method.getName();
        parentTest.set(ReporterHelper.startTest(testMethod));
        parentTest.get().log(LogStatus.INFO, "[TEST STARTED]: >>>>>> { " + testMethod + " } <<<<<< ");
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Take base64Screenshot screenshot.
            String base64Screenshot = "data:image/png;base64,"
                    + ((TakesScreenshot) ThreadLocalDriver.getTLDriver()).getScreenshotAs(OutputType.BASE64);
            // ExtentReports log and screenshot operations for failed tests.
            parentTest.get().log(LogStatus.FAIL, "[TEST FAILED]: >>>>>>{ " + testMethod + " }:" + result.getThrowable(),
                    parentTest.get().addBase64ScreenShot(base64Screenshot));
        } else if (result.getStatus() == ITestResult.SKIP) {
            parentTest.get().log(LogStatus.SKIP, "[TEST SKIPPED]: >>>>>>{ " + testMethod + " }:" + result.getThrowable());
        } else {
            parentTest.get().log(LogStatus.PASS, "[TEST COMPLETED]: >>>>>> { " + testMethod + " } <<<<<<");
        }
    }

    @AfterClass
    public void afterClass() {
        ExtentManager.getReporter().endTest(parentTest.get());
        ExtentManager.getReporter().flush();
        parentTest.remove();
    }

    @AfterTest
    public void afterTest() {
        ThreadLocalDriver.getTLDriver().quit();
    }

}