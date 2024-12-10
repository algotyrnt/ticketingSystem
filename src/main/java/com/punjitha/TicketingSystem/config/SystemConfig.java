package com.punjitha.TicketingSystem.config;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class SystemConfig {
    private int totalTickets; // Total number of tickets to be released
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity; // Maximum number of tickets that can be held by a ticket pool
}
