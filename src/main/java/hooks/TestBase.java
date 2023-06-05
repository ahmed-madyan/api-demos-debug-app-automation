package hooks;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.reader_manager.properties_reader.ConfigUtils;
import webdriver_waits.Waits;

public class TestBase {
    private static AndroidDriver androidDriver;

    @BeforeClass(alwaysRun = true)
    protected void initDriver() {
        ConfigUtils.setConfigProperties();
        switch (ConfigUtils.getExecution_Platform()) {
            case "local" -> setAndroidDriver(DriverLocalService.localServiceInitialization());
            case "remote" -> setAndroidDriver(BrowserStackConfig.browserStackInitialization());
            default -> {
                System.out.println("Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
        Waits.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container"));
    }

    @AfterClass(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        DriverManager.quitDriver();
        if (ConfigUtils.getExecution_Platform().equals("local")) {
            //Stop the server with the builder
            DriverLocalService.localServiceTermination();
        }
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }

    public static void setAndroidDriver(AndroidDriver androidDriver) {
        TestBase.androidDriver = androidDriver;
    }
}