package com.doodle.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Message {

    private String text;
    private String creator;
    private final LocalDateTime createdOn;

    public Message() {
        this.createdOn = LocalDateTime.now();
    }

    public Message(final String text, final String creator) {
        this(text, creator, LocalDateTime.now());
    }

    public Message(final String text, final String creator, final LocalDateTime createdOn) {
        this.text = text;
        this.creator = creator;
        this.createdOn = createdOn;
    }

    public String getText() {
        return text;
    }

    public String getCreator() {
        return creator;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
