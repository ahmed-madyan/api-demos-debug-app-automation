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
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static HashMap<String, Object> browserstackOptions = new HashMap<>();

    protected void browserStack_Setup() {
        //Build the Browser Stack service
        /**********************************************************************************************************/
        /****************************************Specify the App***************************************************/
        //Specify App
        desiredCapabilities.setCapability("app", "CyberSafetyApp");
        /**********************************************************************************************************/
        /****************************************Select device*****************************************************/
        //Select device
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("deviceName", "Google Pixel 3");
        /**********************************************************************************************************/
        /****************************************Select an automation engine***************************************/
        //Select an automation engine
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("projectName", "CyberSafetyApp");
        browserstackOptions.put("buildName", "Regression build no.1");
        /**********************************************************************************************************/
        /****************************************Set debugging options*********************************************/
        //Set debugging options
        //1- Text logs are enabled by default, and cannot be disabled
        //2- Network Logs are disabled by default. To enable network logs use its capability
        browserstackOptions.put("networkLogs", "true");
        //3- Device logs are enabled by default. To disable device logs use its capability
        browserstackOptions.put("deviceLogs", "true");
        //4- Appium logs are enabled by default. To disable Appium logs use its capability
        browserstackOptions.put("appiumLogs", "true");
        //5- Visual logs are disabled by default. To enable visual logs use its capability
        browserstackOptions.put("debug", "true");
        //6- Video logs are enabled by default. Note that video recording slightly increases the text execution time. To disable video logs use its capability
        browserstackOptions.put("video", "true");
        /**********************************************************************************************************/
        /****************************************Set Appium version************************************************/
        //Set Appium version
        browserstackOptions.put("appiumVersion", "2.0.0");
        /**********************************************************************************************************/
        /*********************************Set browser stack capability options ************************************/
        //Set bstack:options capabilities
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        /**********************************************************************************************************/
    }

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