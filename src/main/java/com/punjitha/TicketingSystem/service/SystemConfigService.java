package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.config.SystemConfig;
import com.punjitha.TicketingSystem.utility.ConfigSerializer;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigService {
    private static final String filePath = "src/main/resources/systemConfig.json";

    public SystemConfig getConfig() {
        SystemConfig config = ConfigSerializer.loadFromFile(filePath); // Load from JSON file
        if (config == null) {
            throw new RuntimeException("System configuration not found");
        }
        return config;
    }

    public void saveConfig(SystemConfig config) {
        ConfigSerializer.saveToFile(config, filePath);  // Save configuration to JSON file
    }
}
