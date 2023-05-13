package com.travelin.travelinchat.converters;

import com.travelin.travelinchat.enums.ChatActions;
import org.modelmapper.AbstractConverter;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/15/2023, Mon
 **/

public class StringToChatActionsConverter extends AbstractConverter<String, ChatActions> {
    @Override
    protected ChatActions convert(String source) {
        for (ChatActions action : ChatActions.values()) {
            if (action.getValue().equalsIgnoreCase(source)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Invalid ChatActions value: " + source);
    }
}
