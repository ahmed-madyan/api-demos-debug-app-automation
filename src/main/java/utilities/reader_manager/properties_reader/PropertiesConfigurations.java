package utilities.reader_manager.properties_reader;

public class PropertiesConfigurations {
    private static String baseURI_ST;
    private static String baseURI_SIT;
    private static String fireBase_URI;
    private static String fireBase_API_Key;
    private static String execution_Platform;
    private static String targetRemoteExecution;

    public static void setConfigProperties() {
        setExecution_Platform(PropertiesDataManager.getProperty("executionPlatform", PropertiesDataManager.Capability.EXECUTION_CAPABILITIES));
        setTargetRemoteExecution(PropertiesDataManager.getProperty("targetRemoteExecution", PropertiesDataManager.Capability.EXECUTION_CAPABILITIES));
    }

    public static String getCapability(String capability, String filePath) {
        return PropertiesDataManager.getProperty(capability, filePath);
    }

    public static String getBaseURI_ST() {
        return baseURI_ST;
    }

    private static void setBaseURI_ST(String baseURI_ST) {
        PropertiesConfigurations.baseURI_ST = baseURI_ST;
    }

    public static String getBaseURI_SIT() {
        return baseURI_SIT;
    }

    private static void setBaseURI_SIT(String baseURI_SIT) {
        PropertiesConfigurations.baseURI_SIT = baseURI_SIT;
    }

    public static String getFireBase_URI() {
        return fireBase_URI;
    }

    public static void setFireBase_URI(String fireBase_URI) {
        PropertiesConfigurations.fireBase_URI = fireBase_URI;
    }

    public static String getFireBase_API_Key() {
        return fireBase_API_Key;
    }

    public static void setFireBase_API_Key(String fireBase_API_Key) {
        PropertiesConfigurations.fireBase_API_Key = fireBase_API_Key;
    }

    public static String getExecution_Platform() {
        return execution_Platform;
    }

    public static void setExecution_Platform(String execution_Platform) {
        PropertiesConfigurations.execution_Platform = execution_Platform;
    }

    public static String getTargetRemoteExecution() {
        return targetRemoteExecution;
    }

    public static void setTargetRemoteExecution(String targetRemoteExecution) {
        PropertiesConfigurations.targetRemoteExecution = targetRemoteExecution;
    }
}