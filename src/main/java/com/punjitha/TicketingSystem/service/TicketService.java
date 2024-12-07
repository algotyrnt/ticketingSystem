package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Ticket;

import java.util.Queue;

public class TicketService {

    public synchronized void addTicket(Ticket ticket , Queue<Ticket> ticketQueue, int maximumTicketCapacity){
        while (ticketQueue.size() >= maximumTicketCapacity){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage()); // For Client-Server application
            }
        }

        ticketQueue.add(ticket);
        notifyAll(); // Notify all the waiting threads
        System.out.println("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + ticketQueue.size());
    }

    public synchronized Ticket buyTicket(Queue<Ticket> ticketQueue){
        while (ticketQueue.isEmpty()){
            try {
                wait(); // If queue is empty add Customer to waiting status
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        Ticket ticket = ticketQueue.poll();
        notifyAll(); // Notify all the waiting threads
        System.out.println("Ticket bought by - " + Thread.currentThread().getName() + " - current size is - " + ticketQueue.size() + " - Ticket is - " + ticket);
        return ticket;
    }
}
