package com.cred.chatApp.entity;

import java.time.LocalDateTime;

public class User {
    private String userId;
    private String name;
    private String phoneNo;
    private LocalDateTime lastSeenTimeStamp;

    public User() {}

    public User(String userId, String name, String phoneNo, LocalDateTime lastSeenTimeStamp) {
        this.userId = userId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.lastSeenTimeStamp = lastSeenTimeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDateTime getLastSeenTimeStamp() {
        return lastSeenTimeStamp;
    }

    public void setLastSeenTimeStamp(LocalDateTime lastSeenTimeStamp) {
        this.lastSeenTimeStamp = lastSeenTimeStamp;
    }
}
