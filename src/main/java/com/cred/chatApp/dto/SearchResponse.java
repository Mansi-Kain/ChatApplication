package com.cred.chatApp.dto;

import java.util.List;
import com.cred.chatApp.entity.Message;
import com.cred.chatApp.entity.User;

public class SearchResponse {
    private List<Message> messages;
    private List<User> users;

    public SearchResponse(List<Message> messages, List<User> users) {
        this.messages = messages;
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
