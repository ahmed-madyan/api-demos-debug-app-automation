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


        Assert.assertTrue(DriverManager.getDriverInstance().findElement(views).isDisplayed());
        MobileGestures.click(DriverManager.getDriverInstance(), views);
        Assert.assertTrue(DriverManager.getDriverInstance().findElement(webView).isDisplayed());
        MobileGestures.click(DriverManager.getDriverInstance(), webView);
        Assert.assertTrue(DriverManager.getDriverInstance().findElement(customAdapter).isDisplayed());
        MobileGestures.click(DriverManager.getDriverInstance(), customAdapter);
        MobileGestures.longClick(DriverManager.getDriverInstance(), peopleNames, 2000);
        Assert.assertTrue(DriverManager.getDriverInstance().findElement(widgetListView).isDisplayed());
        Thread.sleep(5000);
        System.out.println(DriverManager.getDriverInstance().findElements(widgetListTitle).get(0).getText() + "\n" + DriverManager.getDriverInstance().findElements(widgetListContent).get(1).getText());

//        Assert.assertEquals(DriverManager.getDriverInstance().findElement(widgetListTitle).getText(), "Sample menu");
//        Assert.assertEquals(DriverManager.getDriverInstance().findElement(widgetListContent).getText(), "Sample action");
//        Thread.sleep(5000);
    }
}