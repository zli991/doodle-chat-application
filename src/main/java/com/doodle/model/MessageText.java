package com.doodle.model;

import com.doodle.sanitization.SanitizedString;

import java.util.regex.Pattern;

/*
 * Just a POC. Would be beneficial in case of SQL injection or preventing various script execution.
 */
public class MessageText extends SanitizedString {

    private static final Pattern PATTERN = Pattern.compile("<(“[^”]*”|'[^’]*’|[^'”>])*>");

    public MessageText(final String value) {
        super(value);
        this.validatePattern(PATTERN);
    }
}
