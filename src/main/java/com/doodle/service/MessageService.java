package com.doodle.service;

import com.doodle.repository.MessageRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
