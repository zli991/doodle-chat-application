package com.doodle.service;

import com.doodle.fixtures.MessageFixtures;
import com.doodle.fixtures.MessageSearchOptionsFixtures;
import com.doodle.mapper.MessageSearchResponseMapper;
import com.doodle.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageServiceTest {

    private MessageService messageService;
    private MessageRepository messageRepositoryMock;

    @BeforeEach
    void setUp() {
        messageRepositoryMock = mock(MessageRepository.class);
        MessageSearchResponseMapper searchResponseMapper = new MessageSearchResponseMapper(new ModelMapper());
        messageService = new MessageService(messageRepositoryMock, searchResponseMapper);
    }

    @Test
    void should_return_page_with_first_5_messages_if_search_options_not_provided() {
        // given
        when(messageRepositoryMock.findAll(any(PageRequest.class))).thenReturn(MessageFixtures.getMessagesPageWithDefaultPageRequest());
        // when
        var response = messageService.findAll(null);
        // then
        assertNotNull(response.getContent());
        assertNotNull(response.getPageable());
        assertEquals(response.getPageable().getPageNumber(), 0);
        assertEquals(response.getPageable().getPageSize(), 5);
        assertEquals(response.getPageable().getSort(), Sort.by(Sort.Direction.DESC, "createdOn"));
    }

    @Test
    void should_return_desired_page_if_page_number_is_provided() {
        // given
        var options = MessageSearchOptionsFixtures.searchOptions();
        when(messageRepositoryMock.findAll(any(PageRequest.class))).thenReturn(MessageFixtures.getMessagesPage(options.createPageRequest()));
        // when
        var response = messageService.findAll(1);
        // then
        assertNotNull(response.getContent());
        assertNotNull(response.getPageable());
        assertEquals(response.getPageable().getPageNumber(), 1);
        assertEquals(response.getPageable().getPageSize(), 5);
        assertEquals(response.getPageable().getSort(), Sort.by(Sort.Direction.DESC, "createdOn"));
    }
}
