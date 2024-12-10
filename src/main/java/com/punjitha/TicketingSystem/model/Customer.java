package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CUSTOMER")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer extends User {

    @Transient
    private int customerRetrievalRate;

    public Customer(int customerRetrievalRate) {
        super();
        this.customerRetrievalRate = customerRetrievalRate;
    }
}
