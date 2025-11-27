package com.cred.chatApp.repository;

import com.cred.chatApp.entity.Message;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository
public class MessageRepository {
    private final Map<String, Message> messages = new HashMap<>();

    public MessageRepository() {
        // Preload messages
        for (int i = 1; i <= 10; i++) {
            Message message = new Message("M" + i, "C1", "U1", "Sample message " + i, LocalDateTime.now());
            messages.put("M" + i, message);
        }
    }

    public Map<String, Message> getMessages() {
        return messages;
    }
}
