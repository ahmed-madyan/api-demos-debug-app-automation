import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    AppiumServiceBuilder serviceBuilder;
    AppiumDriverLocalService appiumService;
    AndroidDriver androidDriver;
    @BeforeClass
    public void buildAppiumService() {
        //Build the Appium service
        serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
    }

    @BeforeClass(dependsOnMethods = "buildAppiumService")
    public void startAppiumService() {
        //Start the server with the builder
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();
    }

    @BeforeClass(dependsOnMethods = "startAppiumService")
    public void initDriver() {
        //Start the server with the builder
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL");
        options.setApp("C:\\Users\\_VOIS\\Documents\\GitHub\\rahul-appium-automation\\src\\test\\resources\\ApiDemos-debug.apk");
        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void quitDriver() {
        //Stop the server with the builder
        androidDriver.quit();
    }

    @AfterClass(dependsOnMethods = "quitDriver")
    public void stopAppiumService() {
        //Stop the server with the builder
        appiumService.stop();
    }
}
