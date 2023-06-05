package hooks;

import io.appium.java_client.android.AndroidDriver;
import hooks.TestBase;

public class DriverManager {
    public static AndroidDriver getDriverInstance() {
        return TestBase.getDriver();
    }
}