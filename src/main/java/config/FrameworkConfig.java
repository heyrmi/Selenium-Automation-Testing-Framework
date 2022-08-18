package config;

public final class FrameworkConfig {

    // Private constructor to avoid external instantiation
    private FrameworkConfig() {
    }

    private static String browser = System.getProperty("browser", "chrome");
}
