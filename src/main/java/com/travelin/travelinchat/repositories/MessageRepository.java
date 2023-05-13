package com.travelin.travelinchat.repositories;

import com.travelin.travelinchat.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/15/2023, Mon
 **/

public interface MessageRepository extends MongoRepository<Message, String> {
}
