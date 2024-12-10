package com.punjitha.TicketingSystem.controller;

import com.punjitha.TicketingSystem.config.SystemConfig;
import com.punjitha.TicketingSystem.service.SimulatorService;
import com.punjitha.TicketingSystem.service.SystemConfigService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
@AllArgsConstructor
public class SystemController {

    private final SystemConfigService systemConfigService;
    private final SimulatorService simulator;

    @GetMapping
    public SystemConfig getConfig() {
        return systemConfigService.getConfig();
    }

    record SystemConfiguration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) { }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> startSystem(@RequestBody SystemConfiguration newConfig) {
        SystemConfig config = new SystemConfig(newConfig.totalTickets(), newConfig.ticketReleaseRate(), newConfig.customerRetrievalRate(), newConfig.maxTicketCapacity());
        systemConfigService.saveConfig(config);
        simulator.startSimulation(config);
        return ResponseEntity.ok("System Started");
    }

}
