import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import actions.AppiumActions;
import actions.ElementActions;
import mobile_gestures.MobileGestures;
import hooks.TestBase;

public class ScrollTest extends TestBase {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By webView = AppiumBy.accessibilityId("WebView");

    @Test
    public void test_Scroll() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        AppiumActions.scrollIntoView(webView, "WebView");
        MobileGestures.click(webView);
    }
}