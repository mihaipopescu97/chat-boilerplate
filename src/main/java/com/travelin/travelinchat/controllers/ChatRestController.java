package com.travelin.travelinchat.controllers;

import com.travelin.travelinchat.dtos.MessageDto;
import com.travelin.travelinchat.entities.Chat;
import com.travelin.travelinchat.entities.Message;
import com.travelin.travelinchat.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/13/2023, Sat
 **/

@RestController
@RequestMapping("/chat")
public class ChatRestController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public ResponseEntity<?> getChatById(@RequestParam(name = "id") final String id) {
        return new ResponseEntity<>(chatService.getChatById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createChat(@RequestBody final Chat chat) {
        return new ResponseEntity<>(chatService.createChat(chat), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteChatById(@RequestParam(name = "id") final String id) {
        return new ResponseEntity<>(chatService.deleteChatById(id), HttpStatus.OK);
    }

    @PutMapping
    public void update(@RequestBody final MessageDto messageDto, @RequestParam(name = "id") final String id) {
        chatService.saveMessage(id, messageDto);
    }
}
