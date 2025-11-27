package com.cred.chatApp.controller;

import com.cred.chatApp.service.ReadReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/messages")
public class ReadReceiptController {
    private final ReadReceiptService readReceiptService;

    public ReadReceiptController(ReadReceiptService readReceiptService) {
        this.readReceiptService = readReceiptService;
    }

    @PostMapping("/{messageId}/read/{userId}")
    public ResponseEntity<Void> markAsRead(@PathVariable String messageId, @PathVariable String userId) {
        readReceiptService.markAsRead(messageId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{messageId}/read-receipts")
    public ResponseEntity<Set<String>> getReadReceipts(@PathVariable String messageId) {
        Set<String> readByUserIds = readReceiptService.getReadReceipts(messageId);
        return ResponseEntity.ok(readByUserIds);
    }
}
