import driver_manager.DriverInitializer;
import driver_manager.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import actions.ElementActions;
import mobile_gestures.MobileGestures;


public class LongPressTest extends DriverInitializer {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By expandableLists = AppiumBy.accessibilityId("Expandable Lists");
    private final By customAdapter = AppiumBy.accessibilityId("1. Custom Adapter");
    private final By peopleNames = AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
    private final By widgetListView = AppiumBy.className("android.widget.ListView");
    private final By widgetListTitle = AppiumBy.id("android:id/title");
    private final By widgetListContent = AppiumBy.id("android:id/title");

    @Test
    public void test_LongPress() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        Assert.assertTrue(ElementActions.findElement(expandableLists).isDisplayed());
        MobileGestures.click(expandableLists);
        Assert.assertTrue(ElementActions.findElement(customAdapter).isDisplayed());
        MobileGestures.click(customAdapter);
        MobileGestures.longClick(DriverManager.getDriverInstance(), peopleNames, 2000);
        Assert.assertTrue(ElementActions.findElement(widgetListView).isDisplayed());
    }
}