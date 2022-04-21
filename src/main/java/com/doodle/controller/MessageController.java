package com.doodle.controller;

import com.doodle.service.MessageService;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/messages")
public class MessageController {

    private final MessageService  messageService;

    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }
}
