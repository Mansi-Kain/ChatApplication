package com.cred.chatApp.service.impl;

import com.cred.chatApp.entity.Message;
import com.cred.chatApp.exception.NotFoundException;
import com.cred.chatApp.repository.MessageRepository;
import com.cred.chatApp.service.ReadReceiptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReadReceiptServiceImpl implements ReadReceiptService {
    private static final Logger logger = LoggerFactory.getLogger(ReadReceiptServiceImpl.class);
    private static final String MESSAGE_NOT_FOUND = "Message not found with id: ";
    private final MessageRepository messageRepository;

    public ReadReceiptServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void markAsRead(String messageId, String userId) throws NotFoundException {
        logger.info("Attempting to mark message {} as read by user {}", messageId, userId);
        
        // Log all available message IDs for debugging
        logger.debug("Available message IDs: {}", messageRepository.getMessages().keySet());
        
        Message message = messageRepository.getMessages().get(messageId);
        if (message == null) {
            String errorMsg = MESSAGE_NOT_FOUND + messageId;
            logger.error(errorMsg);
            throw new NotFoundException(errorMsg);
        }

            
        // Mark as read
        message.getReadByUserIds().add(userId);
        logger.info("Successfully marked message {} as read by user {}", messageId, userId);
    }

    @Override
    public Set<String> getReadReceipts(String messageId) throws NotFoundException {
        Message message = messageRepository.getMessages().get(messageId);
        if (message == null) {
            throw new NotFoundException(MESSAGE_NOT_FOUND + messageId);
        }
        return message.getReadByUserIds();
    }
}
