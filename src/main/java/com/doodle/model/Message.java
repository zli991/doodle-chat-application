package com.doodle.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document
public class Message {

    @MongoId
    private String id;
    private String text;
    private String creator;
    private LocalDateTime createdOn;

    public Message() {
        this.createdOn = LocalDateTime.now();
    }

    public Message(final String text, final String creator) {
        this();
        this.text = text;
        this.creator = creator;
    }

    public Message(final String text, final String creator, final LocalDateTime createdOn) {
        this(text, creator);
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
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
