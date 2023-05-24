import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class MobileGestures {


    public static void longClick(AndroidDriver driver, By elementLocated, int duration) {
        try {
            Waits.elementToBeClickable(elementLocated);
            ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId(),
                    "duration", duration
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doubleClick(AndroidDriver driver, By elementLocated) {
        try {
            Waits.elementToBeClickable(elementLocated);
            ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void click(By elementLocated) {
        try {
            Waits.elementToBeClickable(elementLocated);
            DriverManager.getDriverInstance().executeScript("mobile: clickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) DriverManager.getDriverInstance().findElement(elementLocated)).getId()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void swipe(By elementLocated, Direction direction) {
        try {
//            Waits.visibilityOfElementLocated(elementLocated);
            ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) DriverManager.getDriverInstance().findElement(elementLocated)).getId(),
                    "direction", direction.toString(),
                    "percent", 0.75
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean scroll(By elementLocated, Direction direction) {
        boolean canScrollMore = false;
        try {
//            Waits.visibilityOfElementLocated(elementLocated);
            canScrollMore = (Boolean) ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) ElementActions.findElement(elementLocated)).getId(),
                    "direction", direction.toString(),
                    "percent", 3.0
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canScrollMore;
    }

    enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }
}