package com.travelin.travelinchat.repositories;

import com.travelin.travelinchat.entities.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/12/2023, Fri
 **/

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {
}
