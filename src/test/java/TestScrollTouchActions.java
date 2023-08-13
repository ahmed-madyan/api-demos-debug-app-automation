import actions.ElementActions;
import actions.TouchActions;
import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScrollTouchActions extends DriverInitializer {

    private final By views = AppiumBy.accessibilityId("Views");
    private final By webView = AppiumBy.accessibilityId("WebView");
    private final By expandableLists = AppiumBy.accessibilityId("Expandable Lists");

    @Test
    public void testScrollTouchActions() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        TouchActions.scrollToElement(webView);
        TouchActions.scrollToElement(expandableLists);
        TouchActions.scrollToElement(webView);
        MobileGestures.click(webView);
    }
}
