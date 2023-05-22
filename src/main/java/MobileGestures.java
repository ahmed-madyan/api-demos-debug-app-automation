import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class MobileGestures {
    public static void longClickGesture(AndroidDriver driver, By elementLocated,int duration){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(elementLocated)).getId(),
                "duration", duration
        ));
    }
}
