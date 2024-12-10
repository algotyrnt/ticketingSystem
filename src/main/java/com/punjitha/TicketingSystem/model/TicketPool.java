package com.punjitha.TicketingSystem.model;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
public class TicketPool {
    private final int maximumTicketCapacity;
    private final Queue<Ticket> ticketQueue;

    public TicketPool(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.ticketQueue = new LinkedList<>();
    }
}
