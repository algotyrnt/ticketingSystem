package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Customer extends User {

    @Transient
    private int customerRetrievalRate;

    public Customer(int customerRetrievalRate) {
        super();
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public String toString() {
        return "Customer(id=" + this.getId() + ")";
    }
}
