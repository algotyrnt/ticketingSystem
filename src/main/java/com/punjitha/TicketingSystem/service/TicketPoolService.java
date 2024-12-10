package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Ticket;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
@Transactional
public class TicketPoolService {
    private final LoggerService loggerService;
    private final Queue<Ticket> tickets = new LinkedList<>();

    public TicketPoolService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public synchronized void addTicket(Ticket ticket) {
        tickets.add(ticket);
        loggerService.logAndNotify("Ticket added to pool: " + ticket);
    }

    public synchronized List<Ticket> getAvailableTickets() {
        return new LinkedList<>(tickets);
    }

    public synchronized Ticket removeTicket() {
        if (!tickets.isEmpty()) {
            Ticket ticket = tickets.poll();
            loggerService.logAndNotify("Ticket removed from pool: " + ticket);
            return ticket;
        }
        loggerService.logAndNotify("No tickets available in the pool.");
        return null;
    }
}
