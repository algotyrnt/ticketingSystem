package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Ticket;
import com.punjitha.TicketingSystem.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketPoolService ticketPool;

    public void addTicket() {
        Ticket ticket = Ticket.builder().isSold(false).build();
        ticketPool.addTicket(ticket);
        ticketRepository.save(ticket);
    }

    public List<Ticket> getAvailableTickets() {
        return ticketPool.getAvailableTickets();
    }

    public boolean purchaseTicket() {
        Ticket ticket = ticketPool.removeTicket();
        if (ticket != null) {
            ticket.setSold(true);
            ticketRepository.save(ticket);
            return true;
        }
        return false;
    }
}
