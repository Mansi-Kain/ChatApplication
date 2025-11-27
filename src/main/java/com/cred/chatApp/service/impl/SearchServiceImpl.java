package com.cred.chatApp.service.impl;

import com.cred.chatApp.dto.SearchResponse;
import com.cred.chatApp.entity.Message;
import com.cred.chatApp.entity.User;
import com.cred.chatApp.repository.MessageRepository;
import com.cred.chatApp.repository.UserRepository;
import com.cred.chatApp.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public SearchServiceImpl(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public SearchResponse globalSearch(String keyword) {
        List<User> users = userRepository.getUsers().values().stream()
                .filter(user -> user.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        List<Message> messages = messageRepository.getMessages().values().stream()
                .filter(message -> message.getContent().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        return new SearchResponse(messages, users);
    }
}
