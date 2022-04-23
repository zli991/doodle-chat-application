package com.doodle.dto;

import com.doodle.fixtures.MessageSearchOptionsFixtures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSearchOptionsTest {

    @Test
    void should_create_default_page_request_with_5_elements_from_the_first_page() {
        // given
        // when
        var pageRequest = MessageSearchOptions.defaultPageRequest();
        // then
        assertEquals(pageRequest.getPageNumber(), 0);
        assertEquals(pageRequest.getPageSize(), 5);
    }

    @Test
    void should_create_page_request_with_number_of_elements_provided_in_search_options() {
        // given
        var options = MessageSearchOptionsFixtures.searchOptions();
        // when
        var pageRequest = options.createPageRequest();
        // then
        assertEquals(pageRequest.getPageNumber(), 1);
        assertEquals(pageRequest.getPageSize(), 1);
    }
}
