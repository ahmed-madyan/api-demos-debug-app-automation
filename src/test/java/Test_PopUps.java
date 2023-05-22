import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_PopUps extends TestBase {
    @Test
    public void testPopUps() {
        getDriver().findElement(AppiumBy.accessibilityId("Preference")).click();
        Assert.assertTrue(getDriver().findElement(AppiumBy.accessibilityId("1. Preferences from XML")).isDisplayed());
        getDriver().findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        Assert.assertEquals(getDriver().findElement(AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).getAttribute("checked"), "false");
        Assert.assertEquals(getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).getAttribute("enabled"), "false");
        getDriver().findElement(AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
        Assert.assertEquals(getDriver().findElement(AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).getAttribute("checked"), "true");
        Assert.assertEquals(getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).getAttribute("enabled"), "true");
        getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        getDriver().findElement(AppiumBy.id("android:id/edit")).sendKeys("Ahmed");
        Assert.assertEquals(getDriver().findElement(AppiumBy.id("android:id/edit")).getText(), "Ahmed");
        getDriver().findElement(AppiumBy.id("android:id/button1")).click();
    }
}