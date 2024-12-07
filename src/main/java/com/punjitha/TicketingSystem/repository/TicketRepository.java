package com.punjitha.TicketingSystem.repository;

import com.punjitha.TicketingSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
