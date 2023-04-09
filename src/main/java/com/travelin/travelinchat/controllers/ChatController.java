package com.travelin.travelinchat.controllers;

import com.travelin.travelinchat.dtos.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/2/2023, Sun
 **/

@Controller
//@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    private MessageDto receivePublicMessage(@Payload final MessageDto message) {
        return message;
    }


    // https://www.google.com/search?q=spring+boot+chat+server&oq=spring+boot+chat+&aqs=chrome.3.0i512j69i57j0i512l8.6266j0j7&sourceid=chrome&ie=UTF-8#fpstate=ive&vld=cid:201feae2,vid:o_IjEDAuo8Y
    @MessageMapping("/private-message")
    public MessageDto receivePrivateMessage(@Payload final MessageDto message) {

        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);

        return message;
    }
}
