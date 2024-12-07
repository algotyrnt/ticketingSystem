package com.punjitha.TicketingSystem.controller;

import com.punjitha.TicketingSystem.config.SystemConfig;
import com.punjitha.TicketingSystem.service.SystemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
public class SystemConfigController {

    private final SystemService systemService;

    public SystemConfigController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping
    public SystemConfig getConfig() {
        return systemService.getConfig();
    }

    record SystemConfiguration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {}
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> startSystem(@RequestBody SystemConfiguration newConfig) {
        SystemConfig config = new SystemConfig(newConfig.totalTickets(), newConfig.ticketReleaseRate(), newConfig.customerRetrievalRate(), newConfig.maxTicketCapacity());
        systemService.startSystem(config);
        return ResponseEntity.ok("System Started");
    }

}
