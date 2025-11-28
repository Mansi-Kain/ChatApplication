package com.cred.chatApp.controller;

import com.cred.chatApp.dto.TypingStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typing")
public class TypingTestController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public TypingTestController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/send")
    public String sendTyping(@RequestBody TypingStatusDTO status) {
        messagingTemplate.convertAndSend("/topic/typing", status);
        return "Typing broadcast sent!";
    }
}
