package com.doodle.controller;

import com.doodle.dto.MessageSearchResponse;
import com.doodle.model.Message;
import com.doodle.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping
    @Operation(summary = "Returns page with number of results provided in search options. If no options provided, page with first 5 messages will be returned")
    public Page<MessageSearchResponse> findAll(@RequestParam(required = false) final Integer pageNumber) {
        return messageService.findAll(pageNumber);
    }

    @PostMapping
    @Operation(summary = "Persists new message, and returns saved entry.")
    public Message save(@RequestBody final Message message) {
        return messageService.save(message);
    }
}
