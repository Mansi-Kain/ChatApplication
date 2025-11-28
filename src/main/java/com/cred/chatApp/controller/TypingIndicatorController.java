package com.cred.chatApp.controller;

import com.cred.chatApp.dto.TypingStatusDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TypingIndicatorController {

    @MessageMapping("/typing")
    @SendTo("/topic/typing")
    public TypingStatusDTO broadcastTypingStatus(TypingStatusDTO typingStatus) {
        return typingStatus; // broadcast to all subscribers
    }
}
