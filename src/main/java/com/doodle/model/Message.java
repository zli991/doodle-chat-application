package com.doodle.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Message {

    private MessageText text;
    private String creator;
    private LocalDateTime createdOn = LocalDateTime.now();

    public Message(final MessageText text, final String creator, final LocalDateTime createdOn) {
        this.text = text;
        this.creator = creator;
        this.createdOn = createdOn;
    }

    public Message(final MessageText text, final String creator) {
        this.text = text;
        this.creator = creator;
    }

    public Message() { }

    public String getText() {
        return text.get();
    }

    public String getCreator() {
        return creator;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
