package actions;

import driver_manager.DriverManager;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import utilities.exception_handling.ExceptionHandling;

import java.time.Duration;

public class TouchActions {
    public TouchActions() {
    }

    private static final TouchAction touchActions = new TouchAction(DriverManager.getDriverInstance());
    private static final Dimension dimension = DriverManager.getDriverInstance().manage().window().getSize();

    public static void scrollToElement(By elementLocated) {
        String startPageSource;
        String endPageSource;
        try {
            do {
                startPageSource = DriverManager.getDriverInstance().getPageSource();
                scrollDown();
                endPageSource = DriverManager.getDriverInstance().getPageSource();
            } while ((!ElementState.isDisplayed(elementLocated)) && (!endPageSource.equals(startPageSource)));
            if ((!ElementState.isDisplayed(elementLocated))) {
                do {
                    startPageSource = DriverManager.getDriverInstance().getPageSource();
                    scrollUp();
                    endPageSource = DriverManager.getDriverInstance().getPageSource();
                } while ((!ElementState.isDisplayed(elementLocated)) && (!endPageSource.equals(startPageSource)));
            } else System.out.println("The element does not exist on the whole page");
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    private static void scrollUp() {
        int scrollStart = (int) (dimension.getHeight() * 0.2);
        int scrollEnd = (int) (dimension.getHeight() * 0.8);
        touchActions.press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }

    private static void scrollDown() {
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);
        touchActions.press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }
}