package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.reader_manager.properties_reader.PropertiesDataManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverLocalService {
    private static AppiumDriverLocalService appiumService;
    private static final String CONFIG_FILE_PATH = ("/src/main/resources/config_properties/ExecutionPlatform.properties");

    protected static AndroidDriver localServiceInitialization() {
        //Build the Appium service
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\_VOIS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(PropertiesDataManager.getProperty("executionIPAddress", CONFIG_FILE_PATH))
                .usingPort(Integer.parseInt(PropertiesDataManager.getProperty("executionPort", CONFIG_FILE_PATH)));
        //Start the server with the builder
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();
        //Initialize the driver and launch the app
        try {
            return new AndroidDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", CONFIG_FILE_PATH)),
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