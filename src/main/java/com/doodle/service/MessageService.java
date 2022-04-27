package com.doodle.service;

import com.doodle.model.MessageSearchOptions;
import com.doodle.dto.MessageSearchResponse;
import com.doodle.mapper.MessageSearchResponseMapper;
import com.doodle.model.Message;
import com.doodle.repository.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageSearchResponseMapper searchResponseMapper;

    public MessageService(final MessageRepository messageRepository, final MessageSearchResponseMapper searchResponseMapper) {
        this.messageRepository = messageRepository;
        this.searchResponseMapper = searchResponseMapper;
    }

    public Page<MessageSearchResponse> findAll(final Integer pageNumber) {
        final var pageRequest = createPageRequest(pageNumber);
        final var messagePage = messageRepository.findAll(pageRequest);;
        return searchResponseMapper.convertToMessageSearchResponsePage(messagePage);
    }

    public Message save(final Message message) {
        return messageRepository.save(message);
    }

    private PageRequest createPageRequest(final Integer pageNumber) {
        if (pageNumber != null) {
            return new MessageSearchOptions(pageNumber).createPageRequest();
        }
        return MessageSearchOptions.defaultPageRequest();
    }
}
