package com.travelin.travelinchat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/12/2023, Fri
 **/


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chat")
public class Chat extends BaseEntity{

    @Field(name = "name")
    private String name;

    @DBRef
    private List<Message> messages;

    public void addMessage(final Message message) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(message);
    }
}
