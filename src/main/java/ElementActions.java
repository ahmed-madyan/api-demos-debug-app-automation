import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementActions {

    public static WebElement findElement(By elementLocated) {
        WebElement element = null;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            element = DriverManager.getDriverInstance().findElement(elementLocated);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static void click(By elementLocated) {
        try {
            DriverManager.getDriverInstance().findElement(elementLocated).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendKeys(By elementLocated, String keyToSend) {
        try {
            DriverManager.getDriverInstance().findElement(elementLocated).sendKeys(keyToSend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getText(By elementLocated) {
        String elementText = null;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            elementText = DriverManager.getDriverInstance().findElement(elementLocated).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementText;
    }

    public static String getAttribute(By elementLocated, String attribute) {
        String attributeValue = null;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            attributeValue = DriverManager.getDriverInstance().findElement(elementLocated).getAttribute(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attributeValue;
    }
}
