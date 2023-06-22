package driver_waits;

import driver_manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaits {
    private static final WebDriverWait driverWait = new WebDriverWait(DriverManager.getDriverInstance(), Duration.ofMinutes(1));

    public static void visibilityOfElementLocated(By elementLocated) {
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeClickable(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementToBeClickable(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeSelected(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementToBeSelected(elementLocated));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementToBeUnSelected(By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void elementSelectionStateToBe(By elementLocated, boolean state) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, state));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void textToBePresentInElementLocated(By elementLocated, String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocated, expectedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void textToBe(By elementLocated, String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.textToBe(elementLocated, expectedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}