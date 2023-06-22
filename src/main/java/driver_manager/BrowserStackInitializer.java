package driver_manager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.reader_manager.properties_reader.PropertiesConfigurations;
import utilities.reader_manager.properties_reader.PropertiesDataManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackInitializer {
    private static final String browserStack_ServerURL =
            ("https://" +
                    PropertiesDataManager.getProperty("username", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES) +
                    ":" +
                    PropertiesDataManager.getProperty("accessKey", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES) +
                    "@hub-cloud.browserstack.com/wd/hub");
    private static final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static final HashMap<String, Object> browserstackOptions = new HashMap<>();
    private static AndroidDriver androidDriver;

    protected static AndroidDriver browserStackInitialization() {
        System.out.println("TargetRemoteExecution: " + PropertiesConfigurations.getTargetRemoteExecution());
        switch (PropertiesConfigurations.getTargetRemoteExecution()) {
            case "manual" -> setupManually();
            case "yml" -> setupYML();
            default -> {
                System.out.println("Kindly set the target remote execution option.");
                throw new RuntimeException();
            }
        }
        return androidDriver;
    }

    private static void setupManually() {
        //Build the Browser Stack service
        /**********************************************************************************************************/
        /****************************************Specify the App***************************************************/
        //Specify App
        desiredCapabilities.setCapability("app", PropertiesDataManager.getProperty("app", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        /**********************************************************************************************************/
        /****************************************Select device*****************************************************/
        //Select device
        desiredCapabilities.setCapability("platformName", PropertiesDataManager.getProperty("platformName", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        desiredCapabilities.setCapability("platformVersion", PropertiesDataManager.getProperty("platformVersion", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        desiredCapabilities.setCapability("deviceName", PropertiesDataManager.getProperty("deviceName", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        /**********************************************************************************************************/
        /****************************************Select an automation engine***************************************/
        //Select an automation engine
        desiredCapabilities.setCapability("automationName", PropertiesDataManager.getProperty("automationName", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("projectName", PropertiesDataManager.getProperty("projectName", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        browserstackOptions.put("buildName", PropertiesDataManager.getProperty("buildName", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        /**********************************************************************************************************/
        /****************************************Set debugging options*********************************************/
        //Set debugging options
        //1- Text logs are enabled by default, and cannot be disabled
        //2- Network Logs are disabled by default. To enable network logs use its capability
        browserstackOptions.put("networkLogs", PropertiesDataManager.getProperty("networkLogs", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        //3- Device logs are enabled by default. To disable device logs use its capability
        browserstackOptions.put("deviceLogs", PropertiesDataManager.getProperty("deviceLogs", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        //4- Appium logs are enabled by default. To disable Appium logs use its capability
        browserstackOptions.put("appiumLogs", PropertiesDataManager.getProperty("appiumLogs", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        //5- Visual logs are disabled by default. To enable visual logs use its capability
        browserstackOptions.put("debug", PropertiesDataManager.getProperty("debug", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        //6- Video logs are enabled by default. Note that video recording slightly increases the text execution time. To disable video logs use its capability
        browserstackOptions.put("video", PropertiesDataManager.getProperty("video", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        /**********************************************************************************************************/
        /****************************************Set Appium version************************************************/
        //Set Appium version
        browserstackOptions.put("appiumVersion", PropertiesDataManager.getProperty("appiumVersion", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES));
        /**********************************************************************************************************/
        /*********************************Set browser stack capability options ************************************/
        //Set bstack:options capabilities
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        /**********************************************************************************************************/
        //Initialize the driver and launch the app
        try {
            androidDriver = new AndroidDriver(new URL(browserStack_ServerURL), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setupYML() {
        try {
            MutableCapabilities capabilities = new UiAutomator2Options();
            androidDriver = new AndroidDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.BROWSERSTACK_CAPABILITIES)), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}