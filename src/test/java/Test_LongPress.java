import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_LongPress extends TestBase {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By expandableLists = AppiumBy.accessibilityId("Expandable Lists");
    private final By customAdapter = AppiumBy.accessibilityId("1. Custom Adapter");
    private final By peopleNames = AppiumBy.xpath("//android.widget.TextView[@text='People Names']");
    private final By widgetListView = AppiumBy.className("android.widget.ListView");

    @Test
    public void test_LongPress() throws InterruptedException {
        Assert.assertTrue(getDriver().findElement(views).isDisplayed());
        MobileGestures.click(getDriver(), views);
        Assert.assertTrue(getDriver().findElement(expandableLists).isDisplayed());
        MobileGestures.click(getDriver(), expandableLists);
        Assert.assertTrue(getDriver().findElement(customAdapter).isDisplayed());
        MobileGestures.click(getDriver(), customAdapter);
        MobileGestures.longClick(getDriver(), peopleNames, 2000);
        Assert.assertTrue(getDriver().findElement(widgetListView).isDisplayed());
        Thread.sleep(5000);
    }
}