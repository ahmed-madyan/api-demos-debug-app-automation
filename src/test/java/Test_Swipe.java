import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Swipe extends TestBase {
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
        int i = 0;
//        boolean elementExist;
//        do {
//            System.out.println(DriverManager.getDriverInstance().findElements(imageView).);
//            MobileGestures.swipe(DriverManager.getDriverInstance().findElements(imageView).get(i), MobileGestures.Direction.LEFT);
//            i++;
//            System.out.println(i);
//            elementExist = DriverManager.getDriverInstance().findElements(imageView).get(i - 1).isDisplayed();
//        } while (elementExist);
        Assert.assertEquals(ElementActions.getAttribute(AppiumBy.xpath("//android.widget.ImageView[1]"), "focusable"), "true");
        MobileGestures.swipe(AppiumBy.xpath("//android.widget.ImageView[1]"), MobileGestures.Direction.LEFT);
//        for (int j = 0; j < ElementActions.findElements(imageView).size() - 1; j++) {
//            MobileGestures.swipe(ElementActions.findElements(imageView).get(i), MobileGestures.Direction.LEFT);
//        }
        Thread.sleep(5000);
    }
}