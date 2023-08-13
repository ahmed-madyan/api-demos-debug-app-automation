package actions;

import driver_manager.DriverManager;
import org.openqa.selenium.By;
import driver_waits.FluentWaits;

public class ElementState {

    public static boolean isCheckable(By elementLocated) {
        boolean isCheckable = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.getAttribute(elementLocated, "checkable").equals("true")) {
                isCheckable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isCheckable;
    }

    public static boolean isChecked(By elementLocated) {
        boolean isChecked = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.getAttribute(elementLocated, "checked").equals("true")) {
                isChecked = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isChecked;
    }

    public static boolean isClickable(By elementLocated) {
        boolean isClickable = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.getAttribute(elementLocated, "clickable").equals("true")) {
                isClickable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickable;
    }

    public static boolean isEnabled(By elementLocated) {
        boolean isEnabled = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).isEnabled()) {
                isEnabled = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isEnabled;
    }

    public static boolean isFocusable(By elementLocated) {
        boolean isFocusable = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("focusable").equals("true")) {
                isFocusable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFocusable;
    }

    public static boolean isFocused(By elementLocated) {
        boolean isFocused = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("focused").equals("true")) {
                isFocused = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFocused;
    }

    public static boolean isLongClickable(By elementLocated) {
        boolean isLongClickable = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("long-clickable").equals("true")) {
                isLongClickable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLongClickable;
    }

    public static boolean isPassword(By elementLocated) {
        boolean isPassword = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("password").equals("true")) {
                isPassword = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPassword;
    }

    public static boolean isScrollable(By elementLocated) {
        boolean isScrollable = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("scrollable").equals("true")) {
                isScrollable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollable;
    }

    public static boolean isSelected(By elementLocated) {
        boolean isSelected = false;
        try {
            FluentWaits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).isSelected()) {
                isSelected = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSelected;
    }

    public static boolean isDisplayed(By elementLocated) {
        boolean isDisplayed = false;
        try {
            if (DriverManager.getDriverInstance().findElement(elementLocated).isDisplayed()) {
                isDisplayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDisplayed;
    }
}