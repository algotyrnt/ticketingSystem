package com.punjitha.TicketingSystem.thread;

import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.service.TicketPoolService;

public class VendorThread implements Runnable{

    private final TicketPoolService ticketPoolService;
    private final Vendor vendor;
    private final TicketPool ticketPool;

    public VendorThread(TicketPoolService ticketPoolService, Vendor vendor, TicketPool ticketPool) {
        this.ticketPoolService = ticketPoolService;
        this.vendor = vendor;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int j = 0; j < vendor.getTotalTickets(); j++) {
            ticketPoolService.addTicket(vendor, ticketPool);
            try {
                Thread.sleep(1000L * vendor.getTicketReleaseRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
