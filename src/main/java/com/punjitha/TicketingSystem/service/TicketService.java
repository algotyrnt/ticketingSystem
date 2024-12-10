package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Ticket;
import com.punjitha.TicketingSystem.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket createTicket() {
        Ticket ticket = new Ticket();
        return ticketRepository.save(ticket);
    }
}
