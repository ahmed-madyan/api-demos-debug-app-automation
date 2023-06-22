import actions.AppiumActions;
import actions.ElementActions;
import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscellaneousTest extends DriverInitializer {
    private final By preference = AppiumBy.accessibilityId("Preference");
    private final By preferenceFromXML = AppiumBy.accessibilityId("1. Preferences from XML");
    private final By preferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
    private final By wifiCheckBox = AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']");
    private final By wifiSettings = AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']");
    private final By wifiSettingsName = AppiumBy.id("android:id/edit");
    private final By wifiSettingsOkay = AppiumBy.id("android:id/button1");

    @Test
    public void miscellaneousRotation() {

        MobileGestures.click(preference);
        Assert.assertTrue(ElementActions.findElement(preferenceFromXML).isDisplayed());
        MobileGestures.click(preferenceDependencies);
        Assert.assertEquals(ElementActions.getAttribute(wifiCheckBox, "checked"), "false");
        Assert.assertEquals(ElementActions.getAttribute(wifiSettings, "enabled"), "false");
        MobileGestures.click(wifiCheckBox);
        AppiumActions.rotateRight();
        AppiumActions.rotateLeft();
        Assert.assertEquals(ElementActions.getAttribute(wifiCheckBox, "checked"), "true");
        Assert.assertEquals(ElementActions.getAttribute(wifiSettings, "enabled"), "true");
        MobileGestures.click(wifiSettings);
        AppiumActions.setClipboardText("Ahmed");
        ElementActions.sendKeys(wifiSettingsName, AppiumActions.getClipboardText());
        Assert.assertEquals(ElementActions.getText(wifiSettingsName), "Ahmed");
        MobileGestures.click(wifiSettingsOkay);
    }
}