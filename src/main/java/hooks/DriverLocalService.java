package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverLocalService {
    private static AppiumDriverLocalService appiumService;

    protected static AndroidDriver localServiceInitialization() {
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
            return new AndroidDriver(new URL("http://127.0.0.1:4723"),
                    new UiAutomator2Options()
                            .setDeviceName("Pixel 2 XL")
                            .setApp("C:\\Users\\_VOIS\\Documents\\GitHub\\rahul-appium-automation\\src\\main\\resources\\app_binaries\\ApiDemos-debug.apk"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void localServiceTermination() {
        //Stop the server with the builder
        appiumService.stop();
    }
}
