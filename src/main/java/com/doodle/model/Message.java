package com.doodle.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document
public class Message {

    @MongoId
    private String id;
    private final String text;
    private final String creator;
    private final LocalDateTime createdOn;

    public Message(final String text, final String creator) {
        this.text = text;
        this.creator = creator;
        this.createdOn = LocalDateTime.now();
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
