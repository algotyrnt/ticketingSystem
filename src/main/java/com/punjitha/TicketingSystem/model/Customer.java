package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
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

}
