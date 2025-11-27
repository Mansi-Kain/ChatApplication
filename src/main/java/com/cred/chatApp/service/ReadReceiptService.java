package com.cred.chatApp.service;

import java.util.Set;

public interface ReadReceiptService {
    void markAsRead(String messageId, String userId);
    Set<String> getReadReceipts(String messageId);
}
