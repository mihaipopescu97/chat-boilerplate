package com.travelin.travelinchat.controllers;

import com.travelin.travelinchat.dtos.MessageDto;
import com.travelin.travelinchat.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/2/2023, Sun
 **/

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat/{chat-id}")
    public MessageDto receiveChatMessage(@Payload final MessageDto message, @DestinationVariable("chat-id") final String chatId) {
        simpMessagingTemplate.convertAndSend("/chatroom/" + chatId, message);

        chatService.saveMessage(chatId, message);

        return message;
    }
    @MessageMapping("/private-message")
    public MessageDto receivePrivateMessage(@Payload final MessageDto message) {

        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);

        return message;
    }
}
