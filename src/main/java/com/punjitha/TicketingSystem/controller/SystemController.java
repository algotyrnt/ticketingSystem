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
    private final SimulatorService simulatorService;

    @GetMapping("/config")
    public SystemConfig getConfig() {
        return systemConfigService.getConfig();
    }

    @PostMapping("/start")
    public ResponseEntity<String> startSystem(@RequestBody SystemConfig config) {
        systemConfigService.saveConfig(config);
        simulatorService.startSimulation(config);
        return ResponseEntity.ok("System Started");
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopThreadPool() {
        simulatorService.stopSimulation();
        return ResponseEntity.ok("Simulation stopped");
    }
}
