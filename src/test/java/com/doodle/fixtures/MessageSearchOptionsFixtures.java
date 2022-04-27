package com.doodle.fixtures;

import com.doodle.model.MessageSearchOptions;

public final class MessageSearchOptionsFixtures {

    public static MessageSearchOptions searchOptions() {
        final MessageSearchOptions messageSearchOptions = new MessageSearchOptions();
        messageSearchOptions.setPageOptions(new MessageSearchOptions.PageOptions(1));
        return messageSearchOptions;
    }
}
