package assertions;

import actions.ElementState;
import org.openqa.selenium.By;

public class SoftAssert {
    static org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();

    public static void assertElementCheckable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isCheckable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checkable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is checkable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementChecked(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isChecked(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checked");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is checked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementClickable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not clickable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementEnabled(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isEnabled(elementLocated), "Element located with {" + elementLocated.toString() + "} is not enabled");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocusable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isFocusable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focusable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is focusable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocused(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isFocused(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focused");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is focused");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementLongClickable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isLongClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not long-clickable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is long-clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementPassword(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isPassword(elementLocated), "Element located with {" + elementLocated.toString() + "} is not password");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementScrollable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isScrollable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not scrollable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is scrollable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementSelected(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isSelected(elementLocated), "Element located with {" + elementLocated.toString() + "} is not selected");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementDisplayed(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is not displayed");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}