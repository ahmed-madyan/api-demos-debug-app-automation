import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_SwipeScroll extends TestBase {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By webView = AppiumBy.accessibilityId("WebView");
    private final By customAdapter = AppiumBy.accessibilityId("1. Custom Adapter");
    private final By peopleNames = AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
    private final By widgetListView = AppiumBy.className("android.widget.ListView");
    private final By widgetListTitle = AppiumBy.id("android:id/title");
    private final By widgetListContent = AppiumBy.id("android:id/title");

    @Test
    public void test_LongPress() throws InterruptedException {


        Assert.assertTrue(getDriver().findElement(views).isDisplayed());
        MobileGestures.click(getDriver(), views);
        Assert.assertTrue(getDriver().findElement(webView).isDisplayed());
        MobileGestures.click(getDriver(), webView);
        Assert.assertTrue(getDriver().findElement(customAdapter).isDisplayed());
        MobileGestures.click(getDriver(), customAdapter);
        MobileGestures.longClick(getDriver(), peopleNames, 2000);
        Assert.assertTrue(getDriver().findElement(widgetListView).isDisplayed());
        Thread.sleep(5000);
        System.out.println(getDriver().findElements(widgetListTitle).get(0).getText() + "\n" + getDriver().findElements(widgetListContent).get(1).getText());

//        Assert.assertEquals(getDriver().findElement(widgetListTitle).getText(), "Sample menu");
//        Assert.assertEquals(getDriver().findElement(widgetListContent).getText(), "Sample action");
//        Thread.sleep(5000);
    }
}