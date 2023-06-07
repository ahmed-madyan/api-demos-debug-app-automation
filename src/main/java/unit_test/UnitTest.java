package unit_test;

import utilities.reader_manager.properties_reader.PropertiesDataManager;

public class UnitTest {
    public static void main(String[] args) {
        String appPackageMainActivity = PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE_CAPABILITIES);
        System.out.println(PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE_CAPABILITIES));
        PropertiesDataManager.editProperty("mobile_appActivity", "edited", PropertiesDataManager.Capability.MOBILE_CAPABILITIES);
        System.out.println(PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE_CAPABILITIES));
        PropertiesDataManager.editProperty("mobile_appActivity", appPackageMainActivity, PropertiesDataManager.Capability.MOBILE_CAPABILITIES);
        System.out.println(PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE_CAPABILITIES));
    }
}