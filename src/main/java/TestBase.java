import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.MutableCapabilities;
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

    @AfterClass
    protected void tearDownDriver() {
        //Stop the server with the builder
        androidDriver.quit();
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }
}