package com.travelin.travelinchat.enums;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/2/2023, Sun
 **/

public enum ChatActions {
    JOIN("Join"),
    SEND_MESSAGE("Send message"),
    LEAVE("Leave");

    private final String value;

    ChatActions(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
