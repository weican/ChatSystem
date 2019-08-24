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
    public ResponseEntity<?> getMessagesByRoomId(@PathVariable Integer id,
                                                 @RequestParam(defaultValue = "0", required = false) Integer page) {

        final Optional<List<ChatMessage>> messages = messgaeService.getMessageByRoomId(id, page);

        return new ResponseEntity<>(messages.get(), HttpStatus.OK);
    }

    @PostMapping("/rooms/{id}/messages")
    public ResponseEntity<?> postMessagesByRoomId(@PathVariable Integer id, @RequestBody ChatMessageDTO chatMessageDTO) {

        final String messages = messgaeService.postChatMessage(id, chatMessageDTO);

        return new ResponseEntity<>(messages, HttpStatus.CREATED);
    }

    @PostMapping("/users/{id}/messages")
    public ResponseEntity<?> postMessagesToUser(@PathVariable Integer id, @RequestBody ChatMessageDTO chatMessageDTO) {

        final String messages = messgaeService.postPrivateMessageToUser(id, chatMessageDTO);

        return new ResponseEntity<>(messages, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}/messages")
    public ResponseEntity<?> getMessagesToUser(@PathVariable Integer id,
                                               @RequestParam(defaultValue = "0", required = false) Integer page) {

        final Optional<List<PrivateMessage>> privateMessages = messgaeService.getMessageByUserId(id, page);

        return new ResponseEntity<>(privateMessages, HttpStatus.OK);
    }

}
