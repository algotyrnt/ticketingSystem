package com.punjitha.TicketingSystem.thread;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.service.TicketPoolService;

public class CustomerThread implements Runnable{

    private final TicketPoolService ticketPoolService;
    private final Customer customer;
    private final TicketPool ticketPool;

    public CustomerThread(TicketPoolService ticketPoolService, Customer customer, TicketPool ticketPool) {
        this.ticketPoolService = ticketPoolService;
        this.customer = customer;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int j = 0; j < customer.getTotalTickets(); j++) {
            ticketPoolService.buyTicket(customer, ticketPool);
            try {
                Thread.sleep(1000L * customer.getCustomerRetrievalRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
