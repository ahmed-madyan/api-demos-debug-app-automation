import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestBase {
    private AppiumServiceBuilder serviceBuilder;
    private AppiumDriverLocalService appiumService;
    private static AndroidDriver androidDriver;

    private static final String browserStack_UserName = ("ahmedmadyan_oxTGNa");
    private static final String browserStack_AccessKey = ("efFbRGj4yaxcVuPxyJKs");
    private static String browserStack_ServerURL = ("https://" + browserStack_UserName + ":" + browserStack_AccessKey + "@hub-cloud.browserstack.com/wd/hub");
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static HashMap<String, Object> browserstackOptions = new HashMap<>();

    @BeforeClass
    protected void browserStack_Setup() {
        //Build the Browser Stack service

        //Specify App
//        desiredCapabilities.setCapability("app", "CyberSafetyApp");
//
//        //Select device
//        desiredCapabilities.setCapability("device", "Google Pixel 3");
//        desiredCapabilities.setCapability("os", "android");
//        desiredCapabilities.setCapability("os_version", "10.0");
//
//        //Select an automation engine
//        desiredCapabilities.setCapability("automationName", "UIAutomator2");
//
//        //Organize tests
//        browserstackOptions.put("project", "API Demos Debug");
//        browserstackOptions.put("build", "1");
//        browserstackOptions.put("name", "API Demos Debug");
////        browserstackOptions.put("buildTag", "Regression");
////        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
//
//        //Set debugging options
//        //1- Text logs are enabled by default, and cannot be disabled
//        //2- Network Logs are disabled by default. To enable network logs use its capability
//        browserstackOptions.put("networkLogs", "true");
////        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
//        //3- Device logs are enabled by default. To disable device logs use its capability
//        browserstackOptions.put("deviceLogs", "true");
////        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
//        //4- Appium logs are enabled by default. To disable Appium logs use its capability
//        browserstackOptions.put("appiumLogs", "true");
////        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
//        //5- Visual logs are disabled by default. To enable visual logs use its capability
//        browserstackOptions.put("debug", "true");
////        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
//        //6- Video logs are enabled by default. Note that video recording slightly increases the text execution time. To disable video logs use its capability
//        browserstackOptions.put("video", "true");
////        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
//
//        //Set Appium version
//        browserstackOptions.put("appiumVersion", "2.0.0");
//        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        // Use Java Client v6.0.0 or above
        browserstackOptions.put("appiumVersion", "2.0.0");
        browserstackOptions.put("debug", "true");
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("deviceName", "Google Pixel 3");
        desiredCapabilities.setCapability("app", "CyberSafetyApp");

    }

    @BeforeClass(dependsOnMethods = "browserStack_Setup")
    protected void initDriver() {
        //Initialize the driver and launch the app
        try {
            androidDriver = new AndroidDriver(new URL(browserStack_ServerURL), desiredCapabilities);
            Waits.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    protected void tearDownDriver() {
        //Stop the server with the builder
        androidDriver.quit();
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }
}