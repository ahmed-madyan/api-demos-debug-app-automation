import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public static List<WebElement> findElements(By elementLocated) {
        List<WebElement> element = null;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            element = DriverManager.getDriverInstance().findElements(elementLocated);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static void click(By elementLocated) {
        try {
            findElement(elementLocated).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendKeys(By elementLocated, String keyToSend) {
        try {
            findElement(elementLocated).sendKeys(keyToSend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getText(By elementLocated) {
        String elementText = null;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            elementText = findElement(elementLocated).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementText;
    }

    public static String getAttribute(By elementLocated, String attribute) {
        String attributeValue = null;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            attributeValue = findElement(elementLocated).getAttribute(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attributeValue;
    }

    public static int getMiddleLocationX(By elementLocated) {
        int leftLocationX;
        int rightLocationX;
        int middleLocationX = 0;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            leftLocationX = getElementLocationX(elementLocated);
            rightLocationX = getElementWidth(elementLocated);
            middleLocationX = ((leftLocationX + rightLocationX) / 2);
            System.out.println
                    ("Left Location X: " + leftLocationX +
                            "\nRight Location X: " + rightLocationX +
                            "\nMiddle Location X: " + middleLocationX);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return middleLocationX;
    }

    public static int getMiddleLocationY(By elementLocated) {
        int upperLocationY;
        int lowerLocationY;
        int middleLocationY = 0;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            upperLocationY = getElementLocationY(elementLocated);
            lowerLocationY = getElementHeight(elementLocated);
            middleLocationY = ((upperLocationY + lowerLocationY) / 2);
            System.out.println
                    ("Upper Location Y: " + upperLocationY +
                            "\nLower Location Y: " + lowerLocationY +
                            "\nMiddle Location Y: " + middleLocationY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return middleLocationY;
    }

    public static int getElementLocationX(By elementLocated) {
        int elementLocationX = 0;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            elementLocationX = findElement(elementLocated).getLocation().getX();
            System.out.println("Element Location X: " + elementLocationX);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementLocationX;
    }

    public static int getElementWidth(By elementLocated) {
        int elementWidth = 0;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            elementWidth = findElement(elementLocated).getSize().getWidth();
            System.out.println("Element width: " + elementWidth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementWidth;
    }

    public static int getElementLocationY(By elementLocated) {
        int elementLocationY = 0;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            elementLocationY = findElement(elementLocated).getLocation().getY();
            System.out.println("Element Location Y: " + elementLocationY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementLocationY;
    }

    public static int getElementHeight(By elementLocated) {
        int elementHeight = 0;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            elementHeight = findElement(elementLocated).getSize().getHeight();
            System.out.println("Element height: " + elementHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementHeight;
    }
}