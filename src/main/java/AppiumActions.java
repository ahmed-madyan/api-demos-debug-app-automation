import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AppiumActions {
    public static void scrollIntoView(By elementLocated, String elementText) {
        try {
            DriverManager.getDriverInstance().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
            Waits.visibilityOfElementLocated(elementLocated);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}