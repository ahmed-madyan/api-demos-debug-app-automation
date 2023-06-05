import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.reader_manager.properties_reader.ConfigUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    private static AndroidDriver androidDriver;
    private AppiumDriverLocalService appiumService;

    @BeforeClass(alwaysRun = true)
    protected void initDriver() {
        ConfigUtils.setConfigProperties();
        switch (ConfigUtils.getExecution_Platform()) {
            case "local" -> {
                //Build the Appium service
                AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                        .withAppiumJS(new File("C:\\Users\\_VOIS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723);
                //Start the server with the builder
                appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
                appiumService.start();
                //Initialize the driver and launch the app
                try {
                    androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),
                            new UiAutomator2Options()
                                    .setDeviceName("Pixel 2 XL")
                                    .setApp("C:\\Users\\_VOIS\\Documents\\GitHub\\rahul-appium-automation\\src\\main\\resources\\app_binaries\\ApiDemos-debug.apk"));
                    Waits.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container"));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "remote" -> {
                //Initialize the driver and launch the app
                try {
                    MutableCapabilities capabilities = new UiAutomator2Options();
                    androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
                    Waits.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container"));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                System.out.println("Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
    }

    @AfterClass(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        androidDriver.quit();
        if (ConfigUtils.getExecution_Platform().equals("local")) {
            //Stop the server with the builder
            appiumService.stop();
        }
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }
}