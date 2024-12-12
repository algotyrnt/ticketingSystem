package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.Ticket;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketPoolService {
    private final LoggerService loggerService;
    private final TicketService ticketService;
    private final SimpMessagingTemplate messagingTemplate;

    public TicketPool createTicketPool(int maxTicketCapacity) {
        return new TicketPool(maxTicketCapacity);
    }

    public synchronized void addTicket(Vendor vendor, TicketPool ticketPool) {
        while (ticketPool.getTicketQueue().size() >= ticketPool.getMaximumTicketCapacity()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Ticket ticket = ticketService.createTicket();
        ticketPool.getTicketQueue().add(ticket);
        notifyAll();
        loggerService.logAndNotify(vendor + " added " + ticket);
        broadcastAvailableTickets(ticketPool.getTicketQueue().size());
    }

    public synchronized void buyTicket(Customer customer, TicketPool ticketPool) {
        while (ticketPool.getTicketQueue().isEmpty()){
            try {
                wait(); // If queue is empty add Customer to waiting status
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Ticket ticket = ticketPool.getTicketQueue().poll();
        notifyAll();
        loggerService.logAndNotify(customer + " bought " + ticket);
        broadcastAvailableTickets(ticketPool.getTicketQueue().size());
    }


    public void broadcastAvailableTickets(int availableTickets) {
        messagingTemplate.convertAndSend("/topic/tickets", availableTickets);
    }
}
