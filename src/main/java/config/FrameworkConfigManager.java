package config;

import org.aeonbits.owner.ConfigCache;

public class FrameworkConfigManager {

    // To avoid external instantiation
    private FrameworkConfigManager(){}

    public static FrameworkConfig frameworkConfigManager() {
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }
}
