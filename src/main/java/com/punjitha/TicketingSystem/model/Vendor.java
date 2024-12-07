package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class Vendor extends User {

    @Transient
    private int totalTickets;
    @Transient
    private int ticketReleaseRate;
    @Transient
    private TicketPool ticketPool;

    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }
}
