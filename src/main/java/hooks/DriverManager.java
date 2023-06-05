package hooks;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
    public static AndroidDriver getDriverInstance() {
        return TestBase.getDriver();
    }

    public static void quitDriver() {
        getDriverInstance().quit();
    }
}