package com.doodle.service;

import com.doodle.dto.MessageSearchOptions;
import com.doodle.dto.MessageSearchResponse;
import com.doodle.mapper.MessageSearchResponseMapper;
import com.doodle.model.Message;
import com.doodle.repository.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageSearchResponseMapper searchResponseMapper;

    public MessageService(final MessageRepository messageRepository, final MessageSearchResponseMapper searchResponseMapper) {
        this.messageRepository = messageRepository;
        this.searchResponseMapper = searchResponseMapper;
    }

    public Page<MessageSearchResponse> findAll(final MessageSearchOptions searchOptions) {
        final Page<Message> messagePage = getMessagePage(searchOptions);
        return searchResponseMapper.convertToMessageSearchResponsePage(messagePage);
    }

    public Message save(final Message message) {
        return messageRepository.save(message);
    }

    private Page<Message> getMessagePage(final MessageSearchOptions searchOptions) {
        if (searchOptions == null) {
            return messageRepository.findAll(MessageSearchOptions.defaultPageRequest());
        }
        return messageRepository.findAll(searchOptions.createPageRequest());
    }
}
