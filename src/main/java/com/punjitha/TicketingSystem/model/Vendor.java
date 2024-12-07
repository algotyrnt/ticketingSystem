package com.punjitha.TicketingSystem.model;

import jakarta.persistence.*;

@Entity
public class Vendor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int vendorId;
    private String vendorName;
    private String vendorAddress;
    @Transient
    private int totalTickets;
    @Transient
    private int ticketReleaseRate;
    @Transient
    private TicketPool ticketPool;


}
