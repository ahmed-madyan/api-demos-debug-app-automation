import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Test_AppiumBasics extends TestBase {

    @Test
    public void openPreference() throws InterruptedException {
        getDriver().findElement(AppiumBy.accessibilityId("Preference")).click();
        Thread.sleep(5000);
    }
}