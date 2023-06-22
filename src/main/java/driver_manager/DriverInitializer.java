package driver_manager;

import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.reader_manager.properties_reader.PropertiesConfigurations;
import driver_waits.FluentWaits;

import java.time.Duration;

public class DriverInitializer {
    private static AndroidDriver androidDriver;

    @BeforeClass(alwaysRun = true)
    protected void initializeDriver() {
        PropertiesConfigurations.setConfigProperties();
        System.out.println("Execution Platform: " + PropertiesConfigurations.getExecution_Platform());
        switch (PropertiesConfigurations.getExecution_Platform()) {
            case "local" -> setDriver(DriverLocalServiceInitializer.localServiceInitialization());
            case "remote" -> setDriver(BrowserStackInitializer.browserStackInitialization());
            default -> {
                System.out.println("Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
        FluentWaits.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container"));
//        DriverManager.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        DriverManager.quitDriver();
        if (PropertiesConfigurations.getExecution_Platform().equals("local")) {
            //Stop the server with the builder
            DriverLocalServiceInitializer.localServiceTermination();
        }
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }

    private static void setDriver(AndroidDriver androidDriver) {
        DriverInitializer.androidDriver = androidDriver;
    }
}