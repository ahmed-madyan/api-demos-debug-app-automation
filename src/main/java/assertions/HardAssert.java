package assertions;

import actions.ElementActions;
import actions.ElementState;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HardAssert {
    public static void assertElementCheckable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isCheckable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checkable");
            System.out.println("Element located with {" + elementLocated + "} is checkable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementChecked(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isChecked(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checked");
            System.out.println("Element located with {" + elementLocated + "} is checked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementClickable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not clickable");
            System.out.println("Element located with {" + elementLocated + "} is clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementEnabled(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isEnabled(elementLocated), "Element located with {" + elementLocated.toString() + "} is not enabled");
            System.out.println("Element located with {" + elementLocated + "} is enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocusable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isFocusable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focusable");
            System.out.println("Element located with {" + elementLocated + "} is focusable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocused(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isFocused(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focused");
            System.out.println("Element located with {" + elementLocated + "} is focused");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementLongClickable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isLongClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not long-clickable");
            System.out.println("Element located with {" + elementLocated + "} is long-clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementPassword(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isPassword(elementLocated), "Element located with {" + elementLocated.toString() + "} is not password");
            System.out.println("Element located with {" + elementLocated + "} is password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementScrollable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isScrollable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not scrollable");
            System.out.println("Element located with {" + elementLocated + "} is scrollable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementSelected(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isSelected(elementLocated), "Element located with {" + elementLocated.toString() + "} is not selected");
            System.out.println("Element located with {" + elementLocated + "} is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementDisplayed(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is not displayed");
            System.out.println("Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementText(By elementLocated, String expectedText) {
        try {
            Assert.assertEquals(ElementActions.getText(elementLocated).trim(), expectedText.trim());
            System.out.println("Element text {" + ElementActions.getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} is equals to the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertTextToBe(String actualText, String expectedText) {
        try {
            Assert.assertEquals(actualText, expectedText);
            System.out.println("Actual text {" + actualText + "} is equals to the expected text {" + expectedText + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}