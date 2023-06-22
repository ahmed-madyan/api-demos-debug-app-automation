import actions.AppiumActions;
import actions.ElementActions;
import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.reader_manager.properties_reader.PropertiesDataManager;

public class SwipeTest extends DriverInitializer {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By gallery = AppiumBy.accessibilityId("Gallery");
    private final By photos = AppiumBy.accessibilityId("1. Photos");
    private final By imageView = AppiumBy.className("android.widget.ImageView");

    @Test
    public void test_SwipeStepByStep() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        MobileGestures.click(gallery);
        MobileGestures.click(photos);
        Assert.assertEquals(ElementActions.getAttribute(AppiumBy.xpath("//android.widget.ImageView[1]"), "focusable"), "true");
        MobileGestures.swipe(AppiumBy.xpath("//android.widget.ImageView[1]"), MobileGestures.Direction.LEFT);
        Assert.assertEquals(ElementActions.getAttribute(AppiumBy.xpath("//android.widget.ImageView[1]"), "focusable"), "false");
    }

    @Test
    public void test_SwipeUsingAppActivity() {
        AppiumActions.startActivity(PropertiesDataManager.getProperty("mobile_appPackage", PropertiesDataManager.Capability.MOBILE_CAPABILITIES), "io.appium.android.apis.view.Gallery1");
        Assert.assertEquals(ElementActions.getAttribute(AppiumBy.xpath("//android.widget.ImageView[1]"), "focusable"), "true");
        MobileGestures.swipe(AppiumBy.xpath("//android.widget.ImageView[1]"), MobileGestures.Direction.LEFT);
        Assert.assertEquals(ElementActions.getAttribute(AppiumBy.xpath("//android.widget.ImageView[1]"), "focusable"), "false");
    }
}