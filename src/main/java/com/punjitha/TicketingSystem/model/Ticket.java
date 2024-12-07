package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Entity
public class Ticket {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String eventName = "systemEvent";
    private String eventLocation = "systemLocation";
    private String eventDescription = "system created event";

    public Ticket(String eventName, String eventLocation, String eventDescription) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }
}
