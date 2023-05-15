package com.travelin.travelinchat.entities;

import com.travelin.travelinchat.enums.ChatActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "message")
public class Message extends BaseEntity{

    @Field(name = "sender")
    private String senderName;

    @Field(name = "receiver")
    private String receiverName;

    @Field(name = "text")
    private String message;

    @Field(name = "action")
    private ChatActions status;


}
