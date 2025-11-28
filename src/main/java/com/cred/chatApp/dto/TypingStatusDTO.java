package com.cred.chatApp.dto;
public class TypingStatusDTO {

    private String chatId;
    private String userId;
    private boolean typing;

    public TypingStatusDTO() {}

    public TypingStatusDTO(String chatId, String userId, boolean typing) {
        this.chatId = chatId;
        this.userId = userId;
        this.typing = typing;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public boolean isTyping() {
        return typing;
    }

    public void setTyping(boolean typing) {
        this.typing = typing;
    }
}

