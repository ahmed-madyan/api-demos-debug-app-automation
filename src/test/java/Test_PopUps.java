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
        MobileGestures.click(getDriver(), preference);
        Assert.assertTrue(getDriver().findElement(preferenceFromXML).isDisplayed());
        MobileGestures.click(getDriver(), preferenceDependencies);
        Assert.assertEquals(getDriver().findElement(wifiCheckBox).getAttribute("checked"), "false");
        Assert.assertEquals(getDriver().findElement(wifiSettings).getAttribute("enabled"), "false");
        MobileGestures.click(getDriver(), wifiCheckBox);
        Assert.assertEquals(getDriver().findElement(wifiCheckBox).getAttribute("checked"), "true");
        Assert.assertEquals(getDriver().findElement(wifiSettings).getAttribute("enabled"), "true");
        MobileGestures.click(getDriver(), wifiSettings);
        getDriver().findElement(wifiSettingsName).sendKeys("Ahmed");
        Assert.assertEquals(getDriver().findElement(wifiSettingsName).getText(), "Ahmed");
        MobileGestures.click(getDriver(), wifiSettingsOkay);
    }
}