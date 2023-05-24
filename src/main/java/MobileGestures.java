import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class MobileGestures {


    public static void longClick(AndroidDriver driver, By elementLocated, int duration) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId(),
                "duration", duration
        ));
    }

    public static void doubleClick(AndroidDriver driver, By elementLocated) {
        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId()
        ));
    }

    public static void click(AndroidDriver driver, By elementLocated) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId()
        ));
    }

    public static void swipe(AndroidDriver driver, By elementLocated, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public static boolean scroll(AndroidDriver driver, By elementLocated, String direction) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", direction,
                "percent", 3.0
        ));
    }
}