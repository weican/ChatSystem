package com.wales.chat.controller;

import com.wales.chat.dao.MessageMapper;
import com.wales.chat.model.ChatMessage;
import com.wales.chat.service.MessgaeService;
import com.wales.chat.service.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        final String messages = messgaeService.postMessage(id, chatMessageDTO);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping("/messages/user")   // TODO need to change path
    public ResponseEntity<?> postMessagesToUser(@RequestBody ChatMessageDTO chatMessageDTO) {

        final String messages = messgaeService.postMessageToUser(chatMessageDTO);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

//    @GetMapping("/messages/user")   // TODO need to change path
//    public ResponseEntity<?> getMessagesToUser(@RequestBody ChatMessageDTO chatMessageDTO) {
//
//        final String messages = messgaeService.postMessageToUser(chatMessageDTO);
//
//        return new ResponseEntity<>(messages, HttpStatus.OK);
//    }

}
