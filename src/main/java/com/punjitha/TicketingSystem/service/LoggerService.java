package com.punjitha.TicketingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LoggerService {
    private static final String LOG_FILE = "src/main/resources/logs.txt";

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public LoggerService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Method to log messages to the file, and WebSocket
    public void logAndNotify(String message) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String logMessage = dateTime.format(formater)+ " - " + message;

        // Log to file
        logToFile(logMessage);

        // Send to WebSocket for the frontend
        sendToWebSocket(logMessage);
    }

    // Log to a text file
    private void logToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Send log message to WebSocket
    private void sendToWebSocket(String message) {
        messagingTemplate.convertAndSend("/topic/logs", message); // Send log to WebSocket channel
    }
}

