package com.punjitha.TicketingSystem.thread;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.service.LoggerService;
import com.punjitha.TicketingSystem.service.SystemConfigService;
import com.punjitha.TicketingSystem.service.TicketService;
import com.punjitha.TicketingSystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CustomerThread implements Runnable{

    private final LoggerService loggerService;
    private final Customer customer;
    private final TicketService ticketService;

    public CustomerThread(LoggerService loggerService, TicketService ticketService, UserService userService, SystemConfigService systemConfigService) {
        this.loggerService = loggerService;
        this.customer = userService.createCustomer(systemConfigService.getConfig().getCustomerRetrievalRate());
        this.ticketService = ticketService;
    }

    @Override
    public void run() {
        if (ticketService.purchaseTicket()) {
            loggerService.logAndNotify(customer + " purchased a ticket.");
        }
        try {
            Thread.sleep(1000 * customer.getCustomerRetrievalRate());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
