import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {
    private AppiumServiceBuilder serviceBuilder;
    private AppiumDriverLocalService appiumService;
    private static AndroidDriver androidDriver;
    WebDriverWait webDriverWait;
    ;

    @BeforeClass
    protected void buildAppiumService() {
        //Build the Appium service
        serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\_VOIS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);
    }

    @BeforeClass(dependsOnMethods = "buildAppiumService")
    protected void startAppiumService() {
        //Start the server with the builder
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();
    }

    @BeforeClass(dependsOnMethods = "startAppiumService")
    protected void initDriver() {
        //Initialize the driver and launch the app
        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),
                    new UiAutomator2Options()
                            .setDeviceName("Pixel 2 XL")
                            .setApp("C:\\Users\\_VOIS\\Documents\\GitHub\\rahul-appium-automation\\src\\test\\resources\\ApiDemos-debug.apk"));
            webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container")));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    protected void tearDownDriver() {
        //Stop the server with the builder
        androidDriver.quit();
    }

    @AfterClass(dependsOnMethods = "tearDownDriver")
    protected void stopAppiumService() {
        //Stop the server with the builder
        appiumService.stop();
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }
}