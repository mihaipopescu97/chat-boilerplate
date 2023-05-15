package com.travelin.travelinchat.services;

import com.mongodb.MongoException;
import com.travelin.travelinchat.dtos.MessageDto;
import com.travelin.travelinchat.entities.Chat;
import com.travelin.travelinchat.entities.Message;
import com.travelin.travelinchat.repositories.ChatRepository;
import com.travelin.travelinchat.repositories.MessageRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/12/2023, Fri
 **/

@Log4j2
@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Chat getChatById(final String id) {
        return chatRepository.findById(id).orElseThrow(() -> {
            final String message = String.format("Chat : %s not found!", id);

            log.info(message);
            return new MongoException(121, message);
        });
    }


    public Chat createChat(final Chat chat) {
        return chatRepository.save(chat);
    }

    public String deleteChatById(final String id) {
        chatRepository.deleteById(id);
        log.info(String.format("Deleted chat with ID %s", id));
        return id;
    }

    public void saveMessage(final String chatId, final MessageDto messageDto) {

        final Chat chat = getChatById(chatId);

        final Message message = modelMapper.map(messageDto, Message.class);

        chat.addMessage(messageRepository.save(message));

        chatRepository.save(chat);
    }
}
