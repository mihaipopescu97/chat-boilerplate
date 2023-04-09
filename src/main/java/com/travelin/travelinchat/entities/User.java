package com.travelin.travelinchat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;
    private String username;
//    private List<Message> messages;
}
