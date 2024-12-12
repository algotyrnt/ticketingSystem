package com.punjitha.TicketingSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Enable a simple message broker with a prefix for outgoing messages
        registry.enableSimpleBroker("/topic");  // Broadcast messages to "/topic"
//        registry.setApplicationDestinationPrefixes("/app");  // Prefix for incoming messages
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register the STOMP endpoint for WebSocket connections
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:3000").withSockJS();  // "/ws" is the WebSocket endpoint
    }
}
