package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Customer extends User {

    private int totalTickets; // Tickets willing to buy
    private int customerRetrievalRate;

    public Customer(int totalTickets, int customerRetrievalRate) {
        super();
        this.customerRetrievalRate = customerRetrievalRate;
        this.totalTickets = totalTickets;
    }

    public String toString() {
        return "Customer(id=" + this.getId() + ")";
    }
}
