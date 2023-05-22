import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_LongPress extends TestBase {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By expandableLists = AppiumBy.accessibilityId("Expandable Lists");
    private final By customAdapter = AppiumBy.accessibilityId("1. Custom Adapter");
    private final By wifiCheckBox = AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']");
    private final By peopleNames = AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
    private final By wifiSettingsName = AppiumBy.id("android:id/edit");
    private final By wifiSettingsOkay = AppiumBy.id("android:id/button1");

    @Test
    public void test_LongPress() throws InterruptedException {
        Assert.assertTrue(getDriver().findElement(views).isDisplayed());
        getDriver().findElement(views).click();
        Assert.assertTrue(getDriver().findElement(expandableLists).isDisplayed());
        getDriver().findElement(expandableLists).click();
        Assert.assertTrue(getDriver().findElement(customAdapter).isDisplayed());
        getDriver().findElement(customAdapter).click();
        MobileGestures.longClickGesture(getDriver(), peopleNames, 2000);
        Thread.sleep(10000);

//        Assert.assertEquals(getDriver().findElement(wifiCheckBox).getAttribute("checked"), "false");
//        Assert.assertEquals(getDriver().findElement(wifiSettings).getAttribute("enabled"), "false");
//        getDriver().findElement(wifiCheckBox).click();
//        Assert.assertEquals(getDriver().findElement(wifiCheckBox).getAttribute("checked"), "true");
//        Assert.assertEquals(getDriver().findElement(wifiSettings).getAttribute("enabled"), "true");
//        getDriver().findElement(wifiSettings).click();
//        getDriver().findElement(wifiSettingsName).sendKeys("Ahmed");
//        Assert.assertEquals(getDriver().findElement(wifiSettingsName).getText(), "Ahmed");
//        getDriver().findElement(wifiSettingsOkay).click();
    }
}