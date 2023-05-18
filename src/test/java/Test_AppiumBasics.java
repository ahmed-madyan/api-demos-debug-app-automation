import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_AppiumBasics {
    private AppiumServiceBuilder serviceBuilder;
    private AppiumDriverLocalService appiumService;
    private static AndroidDriver androidDriver;

    @BeforeTest
    private void buildAppiumService() {
        //Build the Appium service
        serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
    }

    @BeforeTest(dependsOnMethods = "buildAppiumService")
    private void startAppiumService() {
        //Start the server with the builder
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();
    }

    @BeforeTest(dependsOnMethods = "startAppiumService")
    private void initDriver() {
        //Initialize the driver and launch the app
        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),
                    new UiAutomator2Options()
                            .setDeviceName("Pixel 2 XL")
                            .setApp("C:\\Users\\_VOIS\\Documents\\GitHub\\rahul-appium-automation\\src\\test\\resources\\ApiDemos-debug.apk"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    private void quitDriver() {
        //Stop the server with the builder
        androidDriver.quit();
    }

    @AfterTest(dependsOnMethods = "quitDriver")
    private void stopAppiumService() {
        //Stop the server with the builder
        appiumService.stop();
    }

    public static AndroidDriver getDriver() {
        return androidDriver;
    }

    @Test
    public void openPreference() throws InterruptedException {
        getDriver().findElement(AppiumBy.accessibilityId("Preference")).click();
        Thread.sleep(5000);
    }
}