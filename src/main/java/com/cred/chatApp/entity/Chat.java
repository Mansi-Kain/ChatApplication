package com.cred.chatApp.entity;

import java.util.List;

/**
 * Represents a chat in the application.
 */
public class Chat {
    private String chatId;
    private List<String> participants;
    private boolean isGroup;
    private String name; // only for group chats

    public Chat() {}

    public Chat(String chatId, List<String> participants, boolean isGroup, String name) {
        this.chatId = chatId;
        this.participants = participants;
        this.isGroup = isGroup;
        this.name = name;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
