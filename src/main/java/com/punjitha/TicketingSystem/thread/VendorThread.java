package com.punjitha.TicketingSystem.thread;

import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.service.SystemConfigService;
import com.punjitha.TicketingSystem.service.TicketService;
import com.punjitha.TicketingSystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class VendorThread implements Runnable{
    private final TicketService ticketService;
    private final Vendor vendor;
    private final int totalTickets;

    public VendorThread(TicketService ticketService, UserService userService, SystemConfigService systemConfigService) {
        this.ticketService = ticketService;
        this.vendor = userService.createVendor(systemConfigService.getConfig().getTicketReleaseRate());
        this.totalTickets = systemConfigService.getConfig().getTotalTickets();
    }


    @Override
    public void run() {
        for (int j = 0; j < totalTickets; j++) {
            ticketService.addTicket();
            try {
                Thread.sleep(1000 * vendor.getTicketReleaseRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
