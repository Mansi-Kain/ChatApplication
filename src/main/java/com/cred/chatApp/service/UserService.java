package com.cred.chatApp.service;

import com.cred.chatApp.entity.User;

import java.util.List;

public interface UserService {
    List<User> searchUsers(String query);
    User getUser(String userId);
}
