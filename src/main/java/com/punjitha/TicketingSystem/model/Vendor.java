package com.punjitha.TicketingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

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

    public Vendor() {
    }

    public String toString() {
        return "Vendor(super=" + super.toString() + ", totalTickets=" + this.totalTickets + ", ticketReleaseRate=" + this.ticketReleaseRate + ", ticketPool=" + this.ticketPool + ")";
    }
}
