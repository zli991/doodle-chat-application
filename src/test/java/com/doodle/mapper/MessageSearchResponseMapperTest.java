package com.doodle.mapper;

import com.doodle.model.Message;
import com.doodle.model.MessageText;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSearchResponseMapperTest {

    private final MessageSearchResponseMapper mapper = new MessageSearchResponseMapper(new ModelMapper());

    @Test
    void should_convert_message_page_to_message_search_response_page() {
        // given
        final var message = new Message(new MessageText("test message"), "dummyUser");
        final var page = new PageImpl<>(List.of(message));
        // when
        final var messageSearchResponses = mapper.convertToMessageSearchResponsePage(page);
        // then
        assertEquals(messageSearchResponses.getTotalElements(), 1);
        assertEquals(messageSearchResponses.getTotalPages(), 1);
        assertEquals(messageSearchResponses.getContent().get(0).getCreator(), message.getCreator());
    }
}
