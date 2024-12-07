package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;

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

    public Ticket() {
    }

    public Ticket(String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}
