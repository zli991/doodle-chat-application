package com.doodle.model;

import com.doodle.sanitization.exception.SanitizationException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MessageTextTest {

    @Test
    void should_throw_an_exception_if_html_tag_is_passed_in_message() {
        // given
        final var text = "<div>";
        // when
        // then
        assertThrows(SanitizationException.class, () -> new MessageText(text));
    }

    @Test
    void should_create_message_text_object_for_non_html_tag_text() {
        // given
        final var text = "this is a new message";
        // when
        final var messageText = new MessageText(text);
        // then
        assertEquals(messageText.get(), text);
    }
}