package com.cred.chatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
<<<<<<< HEAD
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
=======
        config.enableSimpleBroker("/topic");                 // Clients will subscribe here
        config.setApplicationDestinationPrefixes("/app");    // Clients will send messages here
>>>>>>> e05aec4 (finalchanges)
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
<<<<<<< HEAD
        registry.addEndpoint("/ws/typing").setAllowedOrigins("*").withSockJS();
=======
        registry.addEndpoint("/ws/typing")                   // WebSocket handshake URL
                .setAllowedOrigins("*");                    // Allow all origins (CORS)
>>>>>>> e05aec4 (finalchanges)
    }
}
