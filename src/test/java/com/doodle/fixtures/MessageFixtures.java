package com.doodle.fixtures;

import com.doodle.dto.MessageSearchOptions;
import com.doodle.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;

public final class MessageFixtures {

    public static List<Message> getMessages() {
        return List.of(
                new Message("message 1", "creator1", LocalDateTime.of(2022, 4, 20, 5,23)),
                new Message("message 2", "creator2", LocalDateTime.of(2019, 10, 5, 10,49)),
                new Message("message 3", "creator3", LocalDateTime.now()),
                new Message("message 4", "creator4", LocalDateTime.of(2021, 7, 14, 21,54)),
                new Message("message 5", "creator5", LocalDateTime.of(2018, 2, 1, 14,22)),
                new Message("message 6", "creator6", LocalDateTime.of(2022, 9, 21, 9,15)),
                new Message("message 7", "creator7", LocalDateTime.of(2020, 12, 4, 17,52))
        );
    }

    public static Page<Message> getMessagesPageWithDefaultPageRequest() {
        return new PageImpl<>(getMessages(), MessageSearchOptions.defaultPageRequest(), 50);
    }

    public static Page<Message> getMessagesPage(final PageRequest pageRequest) {
        return new PageImpl<>(getMessages(), pageRequest, 50);
    }
}
