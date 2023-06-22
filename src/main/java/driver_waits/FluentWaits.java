package driver_waits;

import driver_manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentWaits {
    private static final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriverInstance())
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    public static void visibilityOfElementLocated(By elementLocated) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeClickable(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            wait.until(ExpectedConditions.elementToBeClickable(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeSelected(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            wait.until(ExpectedConditions.elementToBeSelected(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeUnSelected(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            wait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementSelectionStateToBe(By elementLocated, boolean state) {
        try {
            visibilityOfElementLocated(elementLocated);
            wait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, state));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void textToBePresentInElementLocated(By elementLocated, String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocated, expectedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void textToBe(By elementLocated, String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            wait.until(ExpectedConditions.textToBe(elementLocated, expectedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}