package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.*;;

@Entity
@DiscriminatorValue("VENDOR")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Vendor extends User {

    @Transient
    private int ticketReleaseRate;

    public Vendor(int ticketReleaseRate) {
        super();
        this.ticketReleaseRate = ticketReleaseRate;
    }
}
