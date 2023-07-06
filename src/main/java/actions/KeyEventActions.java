package actions;

import driver_manager.DriverManager;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KeyEventActions {
    public static void clickEnter() {
        try {
            DriverManager.getDriverInstance().pressKey(new KeyEvent(AndroidKey.ENTER));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickHome() {
        try {
            DriverManager.getDriverInstance().pressKey(new KeyEvent(AndroidKey.HOME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickBack() {
        try {
            DriverManager.getDriverInstance().pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}