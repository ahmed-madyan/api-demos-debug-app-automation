import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static final WebDriverWait webDriverWait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(50));

    public static void visibilityOfElementLocated(By elementLocated) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeClickable(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeSelected(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            webDriverWait.until(ExpectedConditions.elementToBeSelected(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementSelectionStateToBe(By elementLocated, boolean state) {
        try {
            visibilityOfElementLocated(elementLocated);
            webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, state));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void textToBePresentInElementLocated(By elementLocated, String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocated, expectedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void textToBe(By elementLocated, String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            webDriverWait.until(ExpectedConditions.textToBe(elementLocated, expectedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}