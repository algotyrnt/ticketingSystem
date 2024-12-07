package com.punjitha.TicketingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Customer extends User {

    @Transient
    private TicketPool ticketPool;
    @Transient
    private int customerRetrievalRate;

    public Customer(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public Customer() {
    }

    public String toString() {
        return "Customer(super=" + super.toString() + ", ticketPool=" + this.ticketPool + ", customerRetrievalRate=" + this.customerRetrievalRate + ")";
    }
}
