package com.doodle.sanitization;

import com.doodle.sanitization.exception.SanitizationException;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.regex.Pattern;

public class SanitizedString {

    private final String value;

    public SanitizedString(final String value) {
        this.value = value;
    }

    @JsonValue
    public String get() {
        return this.value;
    }

    protected final void validatePattern(final Pattern pattern) {
        if (this.value == null || pattern.matcher(this.get()).matches()) {
            throw new SanitizationException(String.format("Invalid value for class %s", this.getClass().getSimpleName()));
        }
    }

    public String toString() {
        return this.value;
    }
}
