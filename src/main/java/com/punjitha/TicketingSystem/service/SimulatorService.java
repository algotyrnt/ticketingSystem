package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.config.SystemConfig;
import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.thread.CustomerThread;
import com.punjitha.TicketingSystem.thread.VendorThread;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimulatorService {
    private final TicketPoolService ticketPoolService;
    private final VendorService vendorService;
    private final CustomerService customerService;

    private final List<Thread> vendorThreads = new ArrayList<>();
    private final List<Thread> customerThreads = new ArrayList<>();
    private final LoggerService loggerService;

    public void startSimulation(SystemConfig config) {
        TicketPool ticketPool = ticketPoolService.createTicketPool(config.getMaxTicketCapacity());

        for(Vendor vendor: vendorService.getAllVendors()) {
            Thread vendorThread = new Thread(new VendorThread(ticketPoolService, vendor, ticketPool), vendor.toString());
            vendorThreads.add(vendorThread);
            loggerService.logAndNotify(vendor + " thread started.");
            vendorThread.start();
        }

        for(Customer customer: customerService.getAllCustomers()) {
            Thread customerThread = new Thread(new CustomerThread(ticketPoolService, customer, ticketPool), customer.toString());
            customerThreads.add(customerThread);
            loggerService.logAndNotify(customer + " thread started.");
            customerThread.start();
        }
    }

    public void stopSimulation() {
        for (Thread vendorThread: vendorThreads) {
            vendorThread.interrupt();
        }
        for (Thread customerThread: customerThreads) {
            customerThread.interrupt();
        }
    }
}
