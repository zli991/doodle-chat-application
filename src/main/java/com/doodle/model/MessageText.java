package com.doodle.model;

import com.doodle.sanitization.SanitizedString;

import java.util.regex.Pattern;

public class MessageText extends SanitizedString {

    private static final Pattern PATTERN = Pattern.compile("<(“[^”]*”|'[^’]*’|[^'”>])*>");

    public MessageText(final String value) {
        super(value);
        this.validatePattern(PATTERN);
    }
}
