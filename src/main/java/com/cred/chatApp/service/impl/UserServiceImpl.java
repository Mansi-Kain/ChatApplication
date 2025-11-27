package com.cred.chatApp.service.impl;

import com.cred.chatApp.entity.User;
import com.cred.chatApp.repository.UserRepository;
import com.cred.chatApp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> searchUsers(String query) {
        return userRepository.getUsers().values().stream()
                .filter(user -> user.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public User getUser(String userId) {
        return userRepository.getUsers().get(userId);
    }
}
