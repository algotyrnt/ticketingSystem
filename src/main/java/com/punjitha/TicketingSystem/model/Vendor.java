package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.*;;

@Entity
@Getter
@NoArgsConstructor
public class Vendor extends User {

    @Transient
    private int totalTickets; // Tickets willing to sell
    @Transient
    private int ticketReleaseRate;

    public Vendor(int totalTickets, int ticketReleaseRate) {
        super();
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public String toString() {
        return "Vendor(id=" + this.getId() + ")";
    }
}
