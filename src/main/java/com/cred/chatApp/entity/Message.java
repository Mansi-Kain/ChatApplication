package com.cred.chatApp.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Message {
    private String messageId;
    private String chatId;
    private String senderId;
    private String content;
    private LocalDateTime timestamp;
    private Set<String> readByUserIds = new HashSet<>();

    public Message() {}

    public Message(String messageId, String chatId, String senderId, String content, LocalDateTime timestamp) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.senderId = senderId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Set<String> getReadByUserIds() {
        return readByUserIds;
    }

    public void setReadByUserIds(Set<String> readByUserIds) {
        this.readByUserIds = readByUserIds;
    }
}
