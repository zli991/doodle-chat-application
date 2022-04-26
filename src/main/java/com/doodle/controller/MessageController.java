package com.doodle.controller;

import com.doodle.dto.MessageSearchOptions;
import com.doodle.dto.MessageSearchResponse;
import com.doodle.model.Message;
import com.doodle.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private final MessageService messageService;

    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/search")
    public Page<MessageSearchResponse> findAll(@RequestBody(required = false) final MessageSearchOptions options) {
        return messageService.findAll(options);
    }

    @PostMapping
    public Message save(@RequestBody final Message message) {
        return messageService.save(message);
    }
}
