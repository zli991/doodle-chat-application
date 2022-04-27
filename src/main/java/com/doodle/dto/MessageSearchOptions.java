package com.doodle.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class MessageSearchOptions {

    private static final String DEFAULT_SORT_COLUMN_NAME = "createdOn";
    private static final int DEFAULT_NUMBER_OF_RESULTS_PER_PAGE = 5;
    private static final int DEFAULT_PAGE_NUMBER = 0;

    private PageOptions pageOptions;

    public MessageSearchOptions(final int pageNumber) {
        pageOptions = new PageOptions(pageNumber);
    }

    public MessageSearchOptions() { }

    public static PageRequest defaultPageRequest() {
        return new PageOptions().createPageRequest();
    }

    public PageRequest createPageRequest() {
        return pageOptions.createPageRequest();
    }

    public PageOptions getPageOptions() {
        return pageOptions;
    }

    public void setPageOptions(final PageOptions pageOptions) {
        this.pageOptions = pageOptions;
    }

    public static class PageOptions {

        private int pageNumber = DEFAULT_PAGE_NUMBER;
        private int numberOfResultsPerPage = DEFAULT_NUMBER_OF_RESULTS_PER_PAGE;

        PageRequest createPageRequest() {
            return PageRequest.of(pageNumber, numberOfResultsPerPage, Sort.Direction.DESC, DEFAULT_SORT_COLUMN_NAME);
        }

        public PageOptions() {
        }

        public PageOptions(final int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(final int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getNumberOfResultsPerPage() {
            return numberOfResultsPerPage;
        }

        public void setNumberOfResultsPerPage(final int numberOfResultsPerPage) {
            this.numberOfResultsPerPage = numberOfResultsPerPage;
        }
    }

}
