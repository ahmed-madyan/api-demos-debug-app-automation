package utilities.reader_manager.properties_reader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesDataManager {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final Properties properties = new Properties();

    private static Properties readProperties(String filePathContentRoot) {
        try {
            InputStream fileInputStream = new FileInputStream((PROJECT_PATH + filePathContentRoot));
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key, String filePathContentRoot) {
        return readProperties(filePathContentRoot).getProperty(key).trim();
    }

    public static void setProperty(String key, String value, String filePathContentRoot) {
        try {
            OutputStream fileOutputStream = new FileOutputStream((PROJECT_PATH + filePathContentRoot));
            properties.put(key, value.trim());
            properties.store(fileOutputStream, null);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key, Capability capability) {
        String filePathContentRoot = null;
        switch (capability) {
            case BROWSERSTACK_CAPABILITIES ->
                    filePathContentRoot = ("/src/main/resources/config_properties/BrowserStackCapabilities.properties");
            case EXECUTION_CAPABILITIES ->
                    filePathContentRoot = ("/src/main/resources/config_properties/ExecutionPlatform.properties");
            case MOBILE_CAPABILITIES ->
                    filePathContentRoot = ("/src/main/resources/config_properties/MobileCapabilities.properties");
        }
        return readProperties(filePathContentRoot).getProperty(key).trim();
    }

    public static void setProperty(String key, String value, Capability capability) {
        String filePathContentRoot = null;
        switch (capability) {
            case BROWSERSTACK_CAPABILITIES ->
                    filePathContentRoot = ("/src/main/resources/config_properties/BrowserStackCapabilities.properties");
            case EXECUTION_CAPABILITIES ->
                    filePathContentRoot = ("/src/main/resources/config_properties/ExecutionPlatform.properties");
            case MOBILE_CAPABILITIES ->
                    filePathContentRoot = ("/src/main/resources/config_properties/MobileCapabilities.properties");
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream((PROJECT_PATH + filePathContentRoot));
            properties.put(key, value.trim());
            properties.store(fileOutputStream, null);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public enum Capability {
        BROWSERSTACK_CAPABILITIES,
        EXECUTION_CAPABILITIES,
        MOBILE_CAPABILITIES
    }
}

