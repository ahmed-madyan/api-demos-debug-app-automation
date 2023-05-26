import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Swipe {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By gallery = AppiumBy.accessibilityId("Gallery");
    private final By photos = AppiumBy.accessibilityId("1. Photos");
    private final By imageView = AppiumBy.className("android.widget.ImageView");

    @Test
    public void test_Swipe() throws InterruptedException {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        MobileGestures.click(gallery);
        MobileGestures.click(photos);
        MobileGestures.swipe(DriverManager.getDriverInstance().findElements(imageView).get(0), MobileGestures.Direction.RIGHT);
        Thread.sleep(5000);
    }
}