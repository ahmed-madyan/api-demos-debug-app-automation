import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    private static AndroidDriver androidDriver;

    @BeforeClass(alwaysRun = true)
    protected void initDriver() {
        //Initialize the driver and launch the app
        try {
            MutableCapabilities capabilities = new UiAutomator2Options();
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            Waits.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        androidDriver.quit();
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }
}