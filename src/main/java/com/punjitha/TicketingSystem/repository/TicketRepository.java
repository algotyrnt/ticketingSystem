package com.punjitha.TicketingSystem.repository;

import com.punjitha.TicketingSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByIsSoldFalse();

}
