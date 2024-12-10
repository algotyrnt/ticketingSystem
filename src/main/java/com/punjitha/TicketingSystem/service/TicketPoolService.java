package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.Ticket;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import org.springframework.stereotype.Service;

@Service
public class TicketPoolService {
    private final LoggerService loggerService;
    private final TicketService ticketService;

    public TicketPoolService(LoggerService loggerService, TicketService ticketService) {
        this.loggerService = loggerService;
        this.ticketService = ticketService;
    }

    public TicketPool createTicketPool(int maxTicketCapacity) {
        return new TicketPool(maxTicketCapacity);
    }

    public synchronized void addTicket(Vendor vendor, TicketPool ticketPool) {
        while (ticketPool.getTicketQueue().size() >= ticketPool.getMaximumTicketCapacity()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket = ticketService.createTicket();
        ticketPool.getTicketQueue().add(ticket);
        notifyAll();
        loggerService.logAndNotify(vendor + " added " + ticket);
    }

    public synchronized void buyTicket(Customer customer, TicketPool ticketPool) {
        while (ticketPool.getTicketQueue().isEmpty()){
            try {
                wait(); // If queue is empty add Customer to waiting status
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket = ticketPool.getTicketQueue().poll();
        notifyAll();
        loggerService.logAndNotify(customer + " bought " + ticket);
    }
}
