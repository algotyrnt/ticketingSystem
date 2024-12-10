package com.punjitha.TicketingSystem.service;

import org.springframework.stereotype.Service;

@Service
public class SimulatorService {

    private final LoggerService loggerService;

    public SimulatorService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void startSimulation() {
        loggerService.logAndNotify("Simulation started");

    }
}
