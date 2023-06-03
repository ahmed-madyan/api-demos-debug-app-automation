import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By webView = AppiumBy.accessibilityId("WebView");
    private final By customAdapter = AppiumBy.accessibilityId("1. Custom Adapter");
    private final By peopleNames = AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
    private final By widgetListView = AppiumBy.className("android.widget.ListView");
    private final By widgetListTitle = AppiumBy.id("android:id/title");
    private final By widgetListContent = AppiumBy.id("android:id/title");

    @Test
    public void test_Scroll() throws InterruptedException {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        AppiumActions.scrollIntoView(webView, "WebView");
        MobileGestures.click(webView);
        Thread.sleep(5000);
    }
}