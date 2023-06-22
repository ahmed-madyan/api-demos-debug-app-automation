import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import actions.AppiumActions;
import actions.ElementActions;
import mobile_gestures.MobileGestures;

public class ScrollTest extends DriverInitializer {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By webView = AppiumBy.accessibilityId("WebView");

    @Test
    public void test_Scroll() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        AppiumActions.scrollIntoView("WebView");
        MobileGestures.click(webView);
    }
}