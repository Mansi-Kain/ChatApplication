package com.cred.chatApp.service.impl;

import com.cred.chatApp.service.TypingService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class TypingServiceImpl implements TypingService {
    private final Map<String, Set<String>> chatTypingMap = new HashMap<>();

    @Override
    public void setTyping(String chatId, String userId, boolean typing) {
        chatTypingMap.computeIfAbsent(chatId, k -> new HashSet<>());
        if (typing) {
            chatTypingMap.get(chatId).add(userId);
        } else {
            chatTypingMap.get(chatId).remove(userId);
        }
    }

    @Override
    public Set<String> getTypingUsers(String chatId) {
        return chatTypingMap.getOrDefault(chatId, new HashSet<>());
    }
}
