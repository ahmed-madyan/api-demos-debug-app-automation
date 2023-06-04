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
    private final By dragResultText = AppiumBy.id("io.appium.android.apis:id/drag_result_text");

    private final By chart = AppiumBy.id("io.appium.android.apis:id/drag_dot_2");

    @Test
    public void test_DragAndDrop() {
        Assert.assertTrue(ElementActions.findElement(views).isDisplayed());
        MobileGestures.click(views);
        Assert.assertTrue(ElementActions.findElement(dragAndDrop).isDisplayed());
        MobileGestures.click(dragAndDrop);
        MobileGestures.drag(dragDot_1, ElementActions.getMiddleLocationX(dragDot_2), ElementActions.getMiddleLocationY(dragDot_2));
        Assert.assertEquals(ElementActions.getText(dragResultText), "Dropped!");
        MobileGestures.drag(dragDot_1, ElementActions.getMiddleLocationX(dragDot_3), ElementActions.getMiddleLocationY(dragDot_3));
        Assert.assertEquals(ElementActions.getText(dragResultText), "Dropped!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void chartTest() {
        int chartSize = DriverManager.getDriverInstance().findElements(chart).size();
        int chartEnabled = 0;

        for (int i = 0; i < chartSize - 1; i++) {
            Assert.assertTrue(DriverManager.getDriverInstance().findElements(chart).get(i).isDisplayed());
            if (DriverManager.getDriverInstance().findElements(chart).get(i).getAttribute("").equals(""))
                chartEnabled++;
        }
    }
}