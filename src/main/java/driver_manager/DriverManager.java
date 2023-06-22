package driver_manager;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
    public static AndroidDriver getDriverInstance() {
        return DriverInitializer.getDriver();
    }

    protected static void quitDriver() {
        getDriverInstance().quit();
    }
}