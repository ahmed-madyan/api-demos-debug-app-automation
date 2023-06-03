import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopUpsTest extends TestBase {
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
        Assert.assertTrue(ElementActions.findElement(preferenceFromXML).isDisplayed());
        MobileGestures.click(preferenceDependencies);
        Assert.assertEquals(ElementActions.getAttribute(wifiCheckBox, "checked"), "false");
        Assert.assertEquals(ElementActions.getAttribute(wifiSettings, "enabled"), "false");
        MobileGestures.click(wifiCheckBox);
        Assert.assertEquals(ElementActions.getAttribute(wifiCheckBox, "checked"), "true");
        Assert.assertEquals(ElementActions.getAttribute(wifiSettings, "enabled"), "true");
        MobileGestures.click(wifiSettings);
        ElementActions.sendKeys(wifiSettingsName, "Ahmed");
        Assert.assertEquals(ElementActions.getText(wifiSettingsName), "Ahmed");
        MobileGestures.click(wifiSettingsOkay);
    }
}