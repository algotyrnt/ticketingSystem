package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
public class Ticket {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String eventName;
    private String eventLocation;
    private String eventDate;
    private String eventTime;
    private String eventDescription;

    public Ticket(String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
    }
}
