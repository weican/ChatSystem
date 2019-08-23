package com.wales.chat.controller;

import com.wales.chat.model.Message;
import com.wales.chat.model.Room;
import com.wales.chat.service.MessgaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessgaeService messgaeService;


    @GetMapping("/rooms/{id}/messages")
    public ResponseEntity<?> getMessagesByRoomId(@PathVariable Integer id) {

        Optional<List<Message>> messages = messgaeService.getMessageByRoomId(id);

        return new ResponseEntity<>(messages.get(), HttpStatus.OK);
    }


}
