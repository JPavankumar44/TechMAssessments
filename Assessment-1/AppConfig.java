public final class AppConfig {
    private final String appName;
    private final int maxUsers;
    private final String version;

    // Constructor to initialize values
    public AppConfig(String appName, int maxUsers, String version) {
        this.appName = appName;
        this.maxUsers = maxUsers;
        this.version = version;
    }

    // Getter methods (No setters to ensure immutability)
    public String getAppName() {
        return appName;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public String getVersion() {
        return version;
    }

    // Main method to test
    public static void main(String[] args) {
        AppConfig config = new AppConfig("MyApp", 1000, "1.0.0");

        // Display configuration values
        System.out.println("App Name: " + config.getAppName());
        System.out.println("Max Users: " + config.getMaxUsers());
        System.out.println("Version: " + config.getVersion());
    }
}
/*2.Custom Immutable Class to Store Configurations
Approach:
Make the class final to prevent subclassing.

Use private final fields to ensure immutability.

Provide a constructor to initialize values.

Do not provide setters, only getters.

Use defensive copying for mutable fields (not applicable here since we use only primitive types and Strings)*/