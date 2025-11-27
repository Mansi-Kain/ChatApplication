package com.cred.chatApp.repository;

import com.cred.chatApp.entity.Chat;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Repository
public class ChatRepository {
    private final Map<String, Chat> chats = new HashMap<>();

    public ChatRepository() {
        // Preload chats with explicit parameter names for clarity
        // Parameters order: chatId, participants, isGroup, name
        chats.put("C1", new Chat("C1", Arrays.asList("U1", "U2"), false, null)); // 1-1 chat
        chats.put("C2", new Chat("C2", Arrays.asList("U3", "U4", "U5"), true, "Group Chat")); // Group chat
    }

    public Map<String, Chat> getChats() {
        return chats;
    }
}
