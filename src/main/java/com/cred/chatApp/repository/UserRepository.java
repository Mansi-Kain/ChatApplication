package com.cred.chatApp.repository;

import com.cred.chatApp.entity.User;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Repository
public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public UserRepository() {
        // Preload 5 users
        users.put("U1", new User("U1", "Mansi", "9999999999", LocalDateTime.now()));
        users.put("U2", new User("U2", "John", "8888888888", LocalDateTime.now()));
        users.put("U3", new User("U3", "Jane", "7777777777", LocalDateTime.now()));
        users.put("U4", new User("U4", "Doe", "6666666666", LocalDateTime.now()));
        users.put("U5", new User("U5", "Smith", "5555555555", LocalDateTime.now()));
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
