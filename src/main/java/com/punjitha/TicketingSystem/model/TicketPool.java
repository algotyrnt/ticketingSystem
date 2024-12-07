package com.punjitha.TicketingSystem.model;

import java.util.Queue;

public class TicketPool {
    private int maxTicketCapacity;
    private Queue<Ticket> ticketPool;

    public TicketPool(int maxTicketCapacity, Queue<Ticket> ticketPool) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.ticketPool = ticketPool;
    }
}



