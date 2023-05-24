import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private static final WebDriverWait webDriverWait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));

    public static void visibilityOfElementLocated(By elementLocated) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
    }

    public static void elementToBeClickable(By elementLocated) {
        visibilityOfElementLocated(elementLocated);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocated));
    }
}
