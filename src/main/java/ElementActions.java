import org.openqa.selenium.By;

public class ElementActions {
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
}
