import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_PopUps extends TestBase {
    private final By preference = AppiumBy.accessibilityId("Preference");
    private final By preferenceFromXML = AppiumBy.accessibilityId("1. Preferences from XML");
    private final By preferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
    private final By wifiCheckBox = AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']");
    private final By wifiSettings = AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']");
    private final By wifiSettingsName = AppiumBy.id("android:id/edit");
    private final By wifiSettingsOkay = AppiumBy.id("android:id/button1");

    @Test
    public void test_PopUps() {
        MobileGestures.click(preference);
        Assert.assertTrue(DriverManager.getDriverInstance().findElement(preferenceFromXML).isDisplayed());
        MobileGestures.click(preferenceDependencies);
        Assert.assertEquals(ElementActions.getAttribute(wifiCheckBox, "checked"), "false");
        Assert.assertEquals(DriverManager.getDriverInstance().findElement(wifiSettings).getAttribute("enabled"), "false");
        MobileGestures.click(wifiCheckBox);
        Assert.assertEquals(DriverManager.getDriverInstance().findElement(wifiCheckBox).getAttribute("checked"), "true");
        Assert.assertEquals(DriverManager.getDriverInstance().findElement(wifiSettings).getAttribute("enabled"), "true");
        MobileGestures.click(wifiSettings);
        DriverManager.getDriverInstance().findElement(wifiSettingsName).sendKeys("Ahmed");
        Assert.assertEquals(ElementActions.getText(wifiSettingsName), "Ahmed");
        MobileGestures.click(wifiSettingsOkay);
    }
}