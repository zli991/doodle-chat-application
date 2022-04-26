package com.doodle.mapper;

import com.doodle.dto.MessageSearchResponse;
import com.doodle.model.Message;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageSearchResponseMapper {

    private final ModelMapper mapper;

    public MessageSearchResponseMapper(final ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Page<MessageSearchResponse> convertToMessageSearchResponsePage(final Page<Message> messagePage) {
        final ArrayList<Message> messages = new ArrayList<>(messagePage.getContent());
        Collections.reverse(messages);
        return new PageImpl<>(
                convertToMessageSearchResponse(messages),
                messagePage.getPageable(),
                messagePage.getTotalElements());
    }

    private List<MessageSearchResponse> convertToMessageSearchResponse(final List<Message> messagePage) {
        return messagePage
                .stream()
                .map(message -> mapper.map(message, MessageSearchResponse.class))
                .collect(Collectors.toList());
    }
}
