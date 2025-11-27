package com.cred.chatApp.service;

import java.util.Set;

public interface TypingService {
    void setTyping(String chatId, String userId, boolean typing);
    Set<String> getTypingUsers(String chatId);
}
