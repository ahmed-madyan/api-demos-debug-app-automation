import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {
    private final By views = AppiumBy.accessibilityId("Views");
    private final By dragAndDrop = AppiumBy.accessibilityId("Drag and Drop");
    private final By dragDot_1 = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
    private final By dragDot_2 = AppiumBy.id("io.appium.android.apis:id/drag_dot_2");
    private final By dragDot_3 = AppiumBy.id("io.appium.android.apis:id/drag_dot_2");

    @Test
    public void test_DragAndDrop() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        Assert.assertTrue(ElementActions.findElement(dragAndDrop).isDisplayed());
        MobileGestures.click(dragAndDrop);
    }
}