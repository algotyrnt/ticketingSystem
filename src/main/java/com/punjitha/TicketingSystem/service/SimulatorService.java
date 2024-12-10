package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.config.SystemConfig;
import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimulatorService {

    private final LoggerService loggerService;
    private final TicketPoolService ticketPoolService;
    private final VendorService vendorService;
    private final CustomerService customerService;

    public void startSimulation(SystemConfig config) {

        TicketPool ticketPool = ticketPoolService.createTicketPool(config.getMaxTicketCapacity());

        for(int i = 0; i < 10; i++) {
            Vendor vendor = vendorService.createVendor(config.getTotalTickets(), config.getTicketReleaseRate());
            loggerService.logAndNotify(vendor + " started selling tickets.");
            vendorService.startVendorThread(vendor, ticketPool, ticketPoolService);

            Customer customer = customerService.createCustomer(config.getCustomerRetrievalRate());
            loggerService.logAndNotify(customer + " started buying tickets.");
            customerService.startCustomerThread(customer, ticketPool, ticketPoolService);
        }
    }
}
