package com.wales.chat.controller;

import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.PrivateMessage;
import com.wales.chat.service.MessgaeService;
import com.wales.chat.service.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessgaeService messgaeService;


    @GetMapping("/rooms/{id}/messages")
    public ResponseEntity<?> getMessagesByRoomId(@PathVariable Integer id) {

        final Optional<List<ChatMessage>> messages = messgaeService.getMessageByRoomId(id);

        return new ResponseEntity<>(messages.get(), HttpStatus.OK);
    }

    @PostMapping("/rooms/{id}/messages")
    public ResponseEntity<?> postMessagesByRoomId(@PathVariable Integer id, @RequestBody ChatMessageDTO chatMessageDTO) {

        final String messages = messgaeService.postChatMessage(id, chatMessageDTO);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping("/user/{id}/messages")
    public ResponseEntity<?> postMessagesToUser(@PathVariable Integer id, @RequestBody ChatMessageDTO chatMessageDTO) {

        final String messages = messgaeService.postPrivateMessageToUser(id, chatMessageDTO);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/user/{id}/messages")
    public ResponseEntity<?> getMessagesToUser(@PathVariable Integer id) {

        final Optional<List<PrivateMessage>> privateMessages = messgaeService.getMessageByUserId(id);

        return new ResponseEntity<>(privateMessages, HttpStatus.OK);
    }

}
