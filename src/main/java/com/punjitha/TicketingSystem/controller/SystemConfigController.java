package com.punjitha.TicketingSystem.controller;

import com.punjitha.TicketingSystem.config.SystemConfig;
import com.punjitha.TicketingSystem.service.SystemConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
public class SystemConfigController {

    private final SystemConfigService systemConfigService;

    public SystemConfigController(SystemConfigService systemConfigService) {
        this.systemConfigService = systemConfigService;
    }

    @GetMapping
    public SystemConfig getConfig() {
        return systemConfigService.getConfig();
    }

    record SystemConfigRecord(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {}
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> updateConfig(@RequestBody SystemConfigRecord newConfig) {
        SystemConfig config = new SystemConfig(newConfig.totalTickets(), newConfig.ticketReleaseRate(), newConfig.customerRetrievalRate(), newConfig.maxTicketCapacity());
        systemConfigService.updateConfig(config);
        return ResponseEntity.ok("Configuration updated successfully.");
    }

}
