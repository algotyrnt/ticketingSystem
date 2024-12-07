package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
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

    public Ticket() {
    }

    public String toString() {
        return "Ticket(id=" + this.id + ", eventName=" + this.eventName + ", eventLocation=" + this.eventLocation + ", eventDescription=" + this.eventDescription + ")";
    }

    public Long getId() {
        return this.id;
    }
}
