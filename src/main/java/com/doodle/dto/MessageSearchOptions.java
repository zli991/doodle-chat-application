package com.doodle.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class MessageSearchOptions {

    private static final String DEFAULT_SORT_COLUMN_NAME = "createdOn";

    private PageOptions pageOptions;

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

        private int pageNumber = 0;
        private int numberOfResultsPerPage = 5;

        PageRequest createPageRequest() {
            return PageRequest.of(pageNumber, numberOfResultsPerPage, Sort.Direction.DESC, DEFAULT_SORT_COLUMN_NAME);
        }

        public PageOptions() {
        }

        public PageOptions(final int pageNumber, final int numberOfResultsPerPage) {
            this.pageNumber = pageNumber;
            this.numberOfResultsPerPage = numberOfResultsPerPage;
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
